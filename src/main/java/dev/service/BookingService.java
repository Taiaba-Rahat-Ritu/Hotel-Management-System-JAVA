package dev.service;

import dev.domain.Booking;
import dev.domain.Hotel;
import dev.repository.BookingRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional

public class BookingService {
    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

 /*   public void create(Booking booking) {
//        booking.setBookingId(booking.getBookingId());
        bookingRepository.create(booking);
    }
*/

    public void create(Booking booking) {
        booking.setBookingId(booking.getBookingId());
        bookingRepository.create(booking);
    }
    public List<Booking> getAll() {
        return bookingRepository.getAll();
    }

    public Booking get(int bookingId) {
        return bookingRepository.get(bookingId);
    }
    public void edit(Booking booking) {
        bookingRepository.edit(booking);
    }


    public void delete(int bookingId) {
        bookingRepository.delete(bookingId);
    }
}
