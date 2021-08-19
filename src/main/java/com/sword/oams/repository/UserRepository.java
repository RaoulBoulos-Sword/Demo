package com.sword.oams.repository;

import com.sword.oams.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    //Boolean existsByEmail(String email);
    //User findByEmail(String email);
    User findByResetPasswordToken(String token);
}
