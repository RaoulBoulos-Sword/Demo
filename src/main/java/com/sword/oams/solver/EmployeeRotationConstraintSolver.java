package com.sword.oams.solver;

import com.sword.oams.domain.Employee;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class EmployeeRotationConstraintSolver implements ConstraintProvider{
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
            roomConflict(constraintFactory),
                teamConflict(constraintFactory)
        };
    }
    
    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Employee.class)
                .join(Employee.class,
                        Joiners.equal(Employee::getRoom),
                        Joiners.lessThan(Employee::getEmployeeId))
                .penalize("Room Conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint teamConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Employee.class)
                .join(Employee.class,
                        Joiners.equal(Employee::getRotationGroup),
                        Joiners.lessThan(Employee::getEmployeeId))
                .penalize("Team Conflict", HardSoftScore.ONE_HARD);
    }

}
