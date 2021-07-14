package com.sword.oams.rest;

import com.sword.oams.domain.Room;
import com.sword.oams.payload.request.RoomRequest;
import com.sword.oams.service.RoomService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/rooms")
@Api(tags = "Rooms")
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("")
    List<Room> allRooms() { return roomService.getAllRooms(); }

    @PostMapping("")
    Room addRoom(@RequestBody RoomRequest request) { return roomService.addRoom(request); }

    @GetMapping("/{id}")
    Room getRoom(@PathVariable Long id) { return roomService.getRoomById(id); }

    @PutMapping("/{id}")
    Room updateRoom(@RequestBody RoomRequest request, @PathVariable Long id) {
        return roomService.updateRoomById(id,request);
    }

    @DeleteMapping("/{id}")
    void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomById(id);
    }
}
