package com.sword.oams.service;

import com.sword.oams.domain.Room;
import com.sword.oams.payload.request.RoomRequest;
import com.sword.oams.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    
    @Autowired
    RoomRepository roomRepository;
    
    public Room addRoom(RoomRequest request) {
        Room newRoom = Room.builder()
                .block(request.getBlock())
                .deskNumber(request.getDeskNumber())
                .build();
        
        return roomRepository.save(newRoom);
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
