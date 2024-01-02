package dev.rest;

import dev.domain.Booking;

import dev.service.BookingService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingRestController {
    private BookingService bookingService;

    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookingService.getAll();
    }

    @GetMapping("/bookings/{bookingId}")
    public Booking getSpecificBookings(@PathVariable("bookingId") Integer bookingId) {
        return bookingService.get(bookingId);
    }

/*    @PutMapping("/bookings/{bookingId}")
    public String UpdateBookings(@PathVariable("hotelID") Integer bookingId, @RequestBody Booking booking) {

        bookingService.edit(booking);
        return "Successful Booking Updated";
    }*/
    @PutMapping("/bookings/{bookingId}")
    public String updateBookings(@PathVariable("bookingId") Integer bookingId, @RequestBody Booking booking) {
        bookingService.edit(booking);
        return "Successful Booking Updated";
    }

    @DeleteMapping("/bookings/{bookingId}")
    public String deleteBookings(@PathVariable("bookingId") Integer bookingId) {
        bookingService.delete(bookingId);
        return "Successful";
    }
    @PostMapping("/bookings")
    public String createBookings(@RequestBody Booking booking) {
        bookingService.create(booking);
        return "Successful";
    }

}
