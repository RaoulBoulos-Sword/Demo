package oams.entity.configuration.repository;

import oams.entity.configuration.domain.ETeam;
import oams.entity.configuration.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(ETeam name);
}
