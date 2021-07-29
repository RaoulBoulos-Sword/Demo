package com.sword.oams.solver;

import com.sword.oams.domain.Employee;
import com.sword.oams.domain.EmployeeRotation;
import com.sword.oams.domain.RotationGroup;
import com.sword.oams.repository.EmployeeRepository;
import com.sword.oams.service.EmployeeService;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class EmployeeRotationConstraintSolver implements ConstraintProvider{

    @Autowired
    EmployeeService employeeService;

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
            roomConflict(constraintFactory),
                //rotCon(constraintFactory)
                //sameRotationConflict(constraintFactory)
        };
    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.fromUniquePair(Employee.class,Joiners.equal(e -> e.getRoom()))
                .penalize("Only one Employee per Room", HardSoftScore.ONE_HARD);
    }

    /*private Constraint sameRotationConflict(ConstraintFactory constraintFactory) {
        Hashtable<Long, RotationGroup> rotations = new Hashtable<>();
        for(Employee employee:employeeService.getAllEmployees()) {
            rotations.put(employee.getEmployeeId(),employee.getRotationGroup());
        }
        return constraintFactory.from(Employee.class)
                .filter(emp -> emp.getRotationGroup() == rotations.get(emp.getEmployeeId()))
                .penalize("Assign Different Rotation",HardSoftScore.ONE_HARD);
    }

    private Constraint rotCon(ConstraintFactory constraintFactory) {

        return constraintFactory.fromUniquePair(Employee.class,Joiners.equal(e -> e.getRotationGroup()))
                .penalize("BC",HardSoftScore.ONE_HARD);

    }*/
}
