package com.sword.oams.repository;

import com.sword.oams.domain.*;
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
    RotationRepository rotationRepository;

    @Autowired
    RoomRepository roomRepository;

    public EmployeeRotation findById(Long id) {
        /*List<RotationGroup> rotationGroups = rotationRepository.findAll();

        if(SINGLETON_EMPLOYEE_ROTATION_ID.equals(id)) {
            return new EmployeeRotation(
                    employeeRepository.findAll(),
                    rotationRepository.findAll(),
                    roomRepository.findAll()
            );
        }
        else {
            Map<Long,List<Employee>> empDict = new HashMap<>();
            List<Employee> employees =  employeeRepository.findAll();
            for(RotationGroup rot:rotationGroups) {
                empDict.put(rot.getRotationId(),employees.stream().filter(x -> x.getRotationGroup()!= null && x.getRotationGroup().getRotationId() == rot.getRotationId()).collect(Collectors.toList()));
            }
            List<Employee> empsDifRot = new ArrayList<>();
            empDict.forEach((k,v) -> {
                //An Employee that has an id won't give an error, but when it's null it fails.
                if(k != id) {
                    empsDifRot.addAll(v);
                }
            });
            return new EmployeeRotation(
                    //empsDifRot,
                    //rotationGroups.stream().filter(c -> c.getRotationId() != id).collect(Collectors.toList()),
                    employeeRepository.findAll(),
                    rotationRepository.findAll(),
                    roomRepository.findAll()
            );
        }*/
        if(!SINGLETON_EMPLOYEE_ROTATION_ID.equals(id)) {
            throw new IllegalStateException("No Employee Rotation with id: "+id);
        }
        List<Employee> employeeList = employeeRepository.findAll();
        List<RotationGroup> rotationGroupsList = rotationRepository.findAll();
        for(Employee employee: employeeList) {
           List<RotationGroup> validRotations = rotationGroupsList.stream().filter(x -> x != employee.getRotationGroup()).collect(Collectors.toList());
           Random rand = new Random();
           int size = validRotations.size();
           employee.setRotationGroup(validRotations.get(rand.nextInt(size)));
        }


        return new EmployeeRotation(
                employeeList,
                rotationGroupsList,
                roomRepository.findAll()
        );
    }

    public void save(EmployeeRotation employeeRotation) {
        for(Employee employee: employeeRotation.getEmployees()) {
            employeeRepository.save(employee);
        }
    }
}
