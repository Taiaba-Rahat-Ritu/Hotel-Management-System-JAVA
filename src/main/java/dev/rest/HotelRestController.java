package dev.rest;

import dev.domain.Hotel;

import dev.service.HotelService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelRestController {


    private HotelService hotelService;

    public HotelRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return hotelService.getAll();
    }

    @GetMapping("/hotels/{hotelID}")
    public Hotel getSpecificHotel(@PathVariable("hotelID") Integer hotelID) {
        return hotelService.get(hotelID);
    }

    @PutMapping("/hotels/{hotelID}")
    public String UpdateHotel(@PathVariable("hotelID") Integer hotelID, @RequestBody Hotel hotel) {

        hotelService.edit(hotel);
        return "Successful Hotel Updated";
    }

    @DeleteMapping("/hotels/{hotelID}")
    public String deleteUser(@PathVariable("hotelID") Integer hotelID) {
        hotelService.delete(hotelID);
        return "Successful";
    }

    @PostMapping("/hotels")
    public String createHotel(@RequestBody Hotel hotel) {
        hotelService.create(hotel);
        return "Successful";
    }
}
