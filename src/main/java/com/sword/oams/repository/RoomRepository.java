package com.sword.oams.repository;

import com.sword.oams.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByBlockAndDeskNumber(String block, int deskNumber);
    Boolean existsByBlockAndDeskNumber(String block, int deskNumber);
}
