package com.sword.oams.repository;

import com.sword.oams.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByBlockAndDeskNumber(char block, int deskNumber);
    List<Room> findByBlock(char block);
    Boolean existsByBlockAndDeskNumber(char block, int deskNumber);
}
