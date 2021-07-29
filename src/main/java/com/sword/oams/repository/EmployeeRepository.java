package com.sword.oams.repository;

import com.sword.oams.domain.Employee;
import com.sword.oams.domain.RotationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    Boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
