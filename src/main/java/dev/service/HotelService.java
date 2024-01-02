package dev.service;

import dev.domain.Hotel;
import dev.repository.HotelRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional

public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void create(Hotel hotel) {
        hotel.setHotelName(hotel.getHotelName().toUpperCase());
        hotelRepository.create(hotel);
    }

    public List<Hotel> getAll() {
        return hotelRepository.getAll();
    }

    public Hotel get(int hotelID) {
        return hotelRepository.get(hotelID);
    }
    public void edit(Hotel hotel) {
         hotelRepository.edit(hotel);
    }


    public void delete(int hotelID) {
        hotelRepository.delete(hotelID);
    }
}
