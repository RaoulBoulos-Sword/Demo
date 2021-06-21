package oams.entity.configuration.repository;

import oams.entity.configuration.domain.ERole;
import oams.entity.configuration.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
