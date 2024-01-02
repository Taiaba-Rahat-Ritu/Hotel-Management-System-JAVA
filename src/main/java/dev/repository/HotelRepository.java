package dev.repository;
import dev.domain.Hotel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;
@Repository
public class HotelRepository {
    private SessionFactory sessionFactory;
    public HotelRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);
    }

    public void edit(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.update(hotel);
    }

    public void delete(int hotelID) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel = get(hotelID);
        session.delete(hotel);
    }

    public List<Hotel> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Hotel> hotelQuery = session.createQuery("from Hotel", Hotel.class);
        return hotelQuery.getResultList();
    }

    public Hotel get(int hotelID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Hotel.class, hotelID);
    }
}
