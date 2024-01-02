package dev.repository;
import dev.domain.Hotel;
import dev.domain.Payment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;
@Repository

public class PaymentRepository {

    private SessionFactory sessionFactory;
    public PaymentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Payment payment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(payment);
    }

    public void edit(Payment payment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(payment);
    }

    public void delete(int paymentId) {
        Session session = sessionFactory.getCurrentSession();
        Payment payment = get(paymentId);
        session.delete(payment);
    }

    public List<Payment> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Payment> paymentQuery = session.createQuery("from Payment", Payment.class);
        return paymentQuery.getResultList();
    }

    public Payment get(int paymentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Payment.class, paymentId);
    }
}
