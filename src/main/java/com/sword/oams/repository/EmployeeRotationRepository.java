package com.sword.oams.repository;

import com.sword.oams.domain.*;
import com.sword.oams.service.EmployeeService;
import com.sword.oams.service.RoomService;
import com.sword.oams.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeRotationRepository {

    public static final Long SINGLETON_EMPLOYEE_ROTATION_ID = 1L;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RotationService rotationService;

    @Autowired
    RoomService roomService;

    public EmployeeRotation findById(Long id) {
        if(!SINGLETON_EMPLOYEE_ROTATION_ID.equals(id)) {
            throw new IllegalStateException("No Employee Rotation with id: "+id);
        }
        for(Employee emp: employeeService.getAllEmployeesByUnavailableStatus()) {
            emp.setRotationGroup(null);
            emp.setRoom(null);
            employeeRepository.save(emp);
        }
        return new EmployeeRotation(
                employeeService.getAllEmployeesByAvailableStatus(),
                rotationService.getAllRotationsByAvailableStatus(),
                roomService.getAllRooms()
        );
    }

    public void save(EmployeeRotation employeeRotation) {
        for(Employee employee: employeeRotation.getEmployees()) {
            employeeRepository.save(employee);
        }
    }
}


