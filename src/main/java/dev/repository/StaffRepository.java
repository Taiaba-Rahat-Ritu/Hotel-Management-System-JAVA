package dev.repository;
import dev.domain.Staff;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StaffRepository {

    private SessionFactory sessionFactory;
    public StaffRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Staff staff) {
        Session session = sessionFactory.getCurrentSession();
        session.save(staff);
    }

    public void edit(Staff staff) {
        Session session = sessionFactory.getCurrentSession();
        session.update(staff);
    }

    public void delete(int staffId) {
        Session session = sessionFactory.getCurrentSession();
        Staff staff = get(staffId);
        session.delete(staff);
    }



    public List<Staff> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Staff> staffQuery = session.createQuery("from Staff", Staff.class);
        return staffQuery.getResultList();
    }

    public Staff get(int staffId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Staff.class, staffId);
    }
}
