package dev.repository;

import dev.domain.UserAddress;
import dev.domain.UserDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAddressRepository {

    private SessionFactory sessionFactory;

    public UserAddressRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(UserAddress userAddress) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userAddress);
    }

    public void edit(UserAddress userAddress) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userAddress);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserAddress userAddress = get(id);
        session.delete(userAddress);
    }

    public List<UserAddress> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<UserAddress> userQuery = session.createQuery("from UserAddress", UserAddress.class);
        return userQuery.getResultList();
    }

    public UserAddress get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserAddress.class, id);
    }
}
