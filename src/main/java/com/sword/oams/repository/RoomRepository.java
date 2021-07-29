package com.sword.oams.repository;

import com.sword.oams.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByBlockAndDeskNumber(String block, int deskNumber);
    Boolean existsByBlockAndDeskNumber(String block, int deskNumber);
}
