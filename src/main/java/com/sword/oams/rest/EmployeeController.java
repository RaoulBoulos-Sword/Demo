package com.sword.oams.rest;

import com.sword.oams.domain.Employee;
import com.sword.oams.payload.request.EmployeeRequest;
import com.sword.oams.repository.EmployeeRepository;
import com.sword.oams.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/employees")
@Api( tags = "Employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    @ApiOperation(value = "This method is used to get the employees.")
    List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/pop")
    Employee addEmployee(@RequestBody EmployeeRequest employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
