package com.sword.oams.service;

import com.sword.oams.domain.Room;
import com.sword.oams.payload.request.RoomRequest;
import com.sword.oams.payload.response.MessageResponse;
import com.sword.oams.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    
    @Autowired
    RoomRepository roomRepository;
    
    public ResponseEntity<?> addRoom(RoomRequest request) {
        if(roomRepository.existsByBlockAndDeskNumber(request.getBlock(), request.getDeskNumber())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Room already exists !"));
        }

        Room newRoom = Room.builder()
                .block(request.getBlock())
                .deskNumber(request.getDeskNumber())
                .build();

        roomRepository.save(newRoom);
        
        return ResponseEntity.ok(new MessageResponse("Success: Room added."));
    }

    public Room getRoomById(Long id) { return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Room Id Not Found")); }

    public List<Room> getAllRooms() { return roomRepository.findAll(); }

    public void deleteRoomById(Long id) { roomRepository.deleteById(id); }

    public Room updateRoomById(Long id, RoomRequest request) {
        return roomRepository.findById(id)
                .map( room -> {
                    room.setBlock(request.getBlock());
                    room.setDeskNumber(request.getDeskNumber());
                    return roomRepository.save(room);
                })
                .orElse(null);
    }
    
}
