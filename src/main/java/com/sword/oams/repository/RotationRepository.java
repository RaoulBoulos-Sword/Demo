package com.sword.oams.repository;

import com.sword.oams.domain.RotationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Optional;

@Repository
public interface RotationRepository extends JpaRepository<RotationGroup, Long> {
    Optional<RotationGroup> findByName(String name);
    Boolean existsByName(String name);
}
