package com.sword.oams.rest;

import com.sword.oams.domain.Room;
import com.sword.oams.exception.RoomNotFoundException;
import com.sword.oams.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/rooms")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @GetMapping("")
    List<Room> allRooms() {
        return roomRepository.findAll();
    }

    @PostMapping("")
    Room addRoom(@RequestBody Room newRoom) {
        return roomRepository.save(newRoom);
    }

    @GetMapping("/{id}")
    Room getRoom(@PathVariable Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PutMapping("/{id}")
    Room updateRoom(@RequestBody Room newRoom,@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    void deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
    }
}
