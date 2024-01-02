package dev.repository;
import dev.domain.Booking;
import dev.domain.Hotel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;
@Repository
public class BookingRepository {
    private SessionFactory sessionFactory;
    public BookingRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.save(booking);
    }

    public void edit(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.update(booking);
    }

    public void delete(int bookingId) {
        Session session = sessionFactory.getCurrentSession();
        Booking booking = get(bookingId);
        session.delete(booking);
    }

    public List<Booking> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Booking> bookingQuery = session.createQuery("from Booking", Booking.class);
        return bookingQuery.getResultList();
    }

    public Booking get(int bookingId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Booking.class, bookingId);
    }

}
