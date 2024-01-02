package dev.repository;

import dev.domain.User;
import dev.domain.UserDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDetailRepository {

    private SessionFactory sessionFactory;

    public UserDetailRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(UserDetail userDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userDetail);
    }

    public void edit(UserDetail userDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userDetail);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserDetail userDetail = get(id);
        session.delete(userDetail);
    }

    public List<UserDetail> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<UserDetail> userQuery = session.createQuery("from UserDetail", UserDetail.class);
        return userQuery.getResultList();
    }

    public UserDetail get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserDetail.class, id);
    }
}
