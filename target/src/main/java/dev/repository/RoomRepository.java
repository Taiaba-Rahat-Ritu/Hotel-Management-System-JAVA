
package dev.repository;

import dev.domain.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository {

    private SessionFactory sessionFactory;

    public RoomRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
    }

    public void edit(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.update(room);
    }

    public void delete(int roomId) {
        Session session = sessionFactory.getCurrentSession();
        Room roomEntity = get(roomId);
        session.delete(roomEntity);
    }

    public List<Room> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Room> roomQuery = session.createQuery("from Room", Room.class);
        return roomQuery.getResultList();
    }

    public Room get(int roomId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Room.class, roomId);
    }
}
