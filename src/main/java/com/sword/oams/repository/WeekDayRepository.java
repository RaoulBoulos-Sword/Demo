package com.sword.oams.repository;

import com.sword.oams.domain.Weekdays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface WeekDayRepository extends JpaRepository<Weekdays, Long> {
    Optional<Weekdays> findByWeekDay(Weekdays weekdays);
}
