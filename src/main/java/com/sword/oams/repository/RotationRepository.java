package com.sword.oams.repository;

import com.sword.oams.domain.RotationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.Optional;

public interface RotationRepository extends JpaRepository<RotationGroup, Long> {
    Optional<RotationGroup> findByName(String name);
}
