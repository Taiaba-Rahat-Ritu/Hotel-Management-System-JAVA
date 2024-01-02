package dev.repository;
import dev.domain.RoomType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.List;


@Repository
public class RoomTypeRepository {

    private SessionFactory sessionFactory;

    public RoomTypeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(RoomType roomType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(roomType);
    }

    public void edit(RoomType roomType) {
        Session session = sessionFactory.getCurrentSession();
        session.update(roomType);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        RoomType roomType = get(id);
        session.delete(roomType);
    }

    public List<RoomType> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<RoomType> roomTypeQuery = session.createQuery("from RoomType", RoomType.class);
        return roomTypeQuery.getResultList();
    }

    public RoomType get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RoomType.class, id);
    }
}
