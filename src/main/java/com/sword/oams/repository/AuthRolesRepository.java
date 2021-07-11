package com.sword.oams.repository;

import com.sword.oams.domain.AuthenticationRole;
import com.sword.oams.domain.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRolesRepository extends JpaRepository<AuthenticationRole, Long> {
    Optional<AuthenticationRole> findByName(ERole name);
}
