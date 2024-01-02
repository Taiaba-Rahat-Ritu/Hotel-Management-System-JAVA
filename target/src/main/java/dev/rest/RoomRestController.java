package dev.rest;

import dev.domain.Room;
import dev.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomRestController {

    private final RoomService roomService;

    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return roomService.getAll();
    }

    @GetMapping("/rooms/{room}")
    public Room getSpecificRoom(@PathVariable("room") Integer room) {
        return roomService.get(room);
    }

    @PutMapping("/rooms/{room}")
    public String updateRoom(@PathVariable("roomId") Integer roomId, @RequestBody Room room) {
        roomService.edit(room);
        return "Successful Room Updated";
    }

    @DeleteMapping("/rooms/{room}")
    public String deleteRoom(@PathVariable("room") Integer room) {
        roomService.delete(room);
        return "Successful Room Deleted";
    }

    @PostMapping("/rooms")
    public String createRoom(@RequestBody Room room) {
        roomService.create(room);
        return "Successful Room Created";
    }
}
