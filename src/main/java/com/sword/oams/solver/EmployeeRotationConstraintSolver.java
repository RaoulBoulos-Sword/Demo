package com.sword.oams.solver;

import com.sword.oams.domain.Employee;
import com.sword.oams.domain.RotationGroup;
import com.sword.oams.repository.EmployeeRepository;
import com.sword.oams.repository.RotationRepository;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.optaplanner.core.api.score.stream.Joiners.equal;

@Service
public class EmployeeRotationConstraintSolver implements ConstraintProvider{

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
            roomConflict(constraintFactory),
                rotationConflict(constraintFactory)
        };
    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.fromUniquePair(Employee.class, equal(e -> e.getRoom()))
                .penalize("Only one Employee per Room", HardSoftScore.ONE_HARD);
    }

    private Constraint rotationConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Employee.class)
                .join(Employee.class,
                        Joiners.equal(Employee::getRotationGroup),
                        Joiners.lessThan(Employee::getEmployeeId))
                .penalize("Same Rotation", HardSoftScore.ONE_HARD);
    }


}
