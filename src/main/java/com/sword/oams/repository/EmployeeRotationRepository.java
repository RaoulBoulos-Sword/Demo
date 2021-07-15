package com.sword.oams.repository;

import com.sword.oams.domain.Employee;
import com.sword.oams.domain.EmployeeRotation;
import com.sword.oams.domain.RotationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeRotationRepository {

    public static final Long SINGLETON_EMPLOYEE_ROTATION_ID = 1L;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RotationRepository rotationRepository;

    @Autowired
    private RoomRepository roomRepository;

    public EmployeeRotation findById(Long id) {
        if(!SINGLETON_EMPLOYEE_ROTATION_ID.equals(id)) {
            throw new IllegalStateException("There is no employee rotation with id ("+id+").");
        }
        return new EmployeeRotation(
            employeeRepository.findAll(),
                rotationRepository.findAll(),
                    roomRepository.findAll()
        );
    }

    public void save(EmployeeRotation employeeRotation) {
        for(Employee employee: employeeRotation.getEmployees()) {
            employeeRepository.save(employee);
        }
    }


}
