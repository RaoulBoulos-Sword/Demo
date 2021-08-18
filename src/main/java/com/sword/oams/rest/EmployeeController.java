package com.sword.oams.rest;

import com.sword.oams.domain.Employee;
import com.sword.oams.payload.request.EmployeeRequest;
import com.sword.oams.payload.response.MessageResponse;
import com.sword.oams.repository.EmployeeRepository;
import com.sword.oams.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/employees")
@Api( tags = "Employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    @ApiOperation(value = "This method is used to get the employees.")
    public List<Employee> getEmployees() { return employeeService.getAllEmployees(); }

    @GetMapping("/available")
    @ApiOperation(value = "This method is used to get all available employees.")
    public List<Employee> availableEmployees() { return employeeService.getAllEmployeesByAvailableStatus(); }

    @GetMapping("/unavailable")
    @ApiOperation(value = "This method is used to get all unavailable employees.")
    public List<Employee> unavailableEmployees() { return employeeService.getAllEmployeesByUnavailableStatus(); }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to add an employee.")
    ResponseEntity<?> addEmployee(@RequestBody EmployeeRequest employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This method is used to get an employee by his id.")
    Employee getEmployee(@PathVariable Long id) { return employeeService.getEmployeeById(id); }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to delete an employee by his id.")
    void deleteEmployee(@PathVariable Long id) { employeeService.deleteEmployeeById(id); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to update an employee by his id.")
    Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        return employeeService.updateEmployeeById(id, request);
    }
}
