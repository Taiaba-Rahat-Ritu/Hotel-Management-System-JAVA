package dev.rest;

import dev.domain.Hotel;
import dev.domain.RoomType;

import dev.service.HotelService;
import dev.service.RoomTypeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RoomTypeRestController {



    private RoomTypeService roomTypeService;

    public RoomTypeRestController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/roomtypes")
    public List<RoomType> getroom() {
        return roomTypeService.getAll();
    }

    @GetMapping("/roomtypes/{roomTypesId}")
    public RoomType getSpecificRoomTypes(@PathVariable("roomTypesId") Integer roomTypesId) {
        return roomTypeService.get(roomTypesId);
    }

    @PutMapping("/roomtypes/{roomTypesId}")
    public String UpdateRoomTypes(@PathVariable("roomTypesId") Integer roomTypesId, @RequestBody RoomType roomType) {

        roomTypeService.edit(roomType);
        return "Successful Room Types Updated";
    }

    @DeleteMapping("/roomtypes/{roomTypesId}")
    public String deleteRoomType(@PathVariable("roomTypesId") Integer roomTypesId) {
        roomTypeService.delete(roomTypesId);
        return "Successful";
    }

    @PostMapping("/roomtypes")
    public String createRoomType(@RequestBody RoomType roomType) {
        roomTypeService.create(roomType);
        return "Successful";
    }
}
