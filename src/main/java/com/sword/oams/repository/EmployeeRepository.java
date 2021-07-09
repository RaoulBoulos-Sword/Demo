package com.sword.oams.repository;

import com.sword.oams.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    Boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
