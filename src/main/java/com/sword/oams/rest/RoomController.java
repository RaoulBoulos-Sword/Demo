package com.sword.oams.rest;

import com.sword.oams.domain.Room;
import com.sword.oams.payload.request.RoomRequest;
import com.sword.oams.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "This method is used to get all rooms.")
    List<Room> allRooms() { return roomService.getAllRooms(); }

    @PostMapping("")
    @ApiOperation(value = "This method is used to add a room.")
    Room addRoom(@RequestBody RoomRequest request) { return roomService.addRoom(request); }

    @GetMapping("/{id}")
    @ApiOperation(value = "This method is used to get a room by its ID.")
    Room getRoom(@PathVariable Long id) { return roomService.getRoomById(id); }

    @PutMapping("/{id}")
    @ApiOperation(value = "This method is used to update a room by its ID.")
    Room updateRoom(@RequestBody RoomRequest request, @PathVariable Long id) {
        return roomService.updateRoomById(id,request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "This method is used to get delete a room by its ID.")
    void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomById(id);
    }
}
