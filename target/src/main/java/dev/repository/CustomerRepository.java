package dev.repository;

import dev.domain.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private SessionFactory sessionFactory;

    public CustomerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    public void edit(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    public void delete(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = get(customerId);
        session.delete(customer);
    }

    public List<Customer> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer", Customer.class);
        return customerQuery.getResultList();
    }

    public Customer get(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }
}







/*
package dev.repository;
import dev.domain.Customer;
import dev.domain.Hotel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;

public class CustomerRepository {

    private SessionFactory sessionFactory;
    public CustomerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    public void edit(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    public void delete(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = get(customerId);
        session.delete(customer);
    }

    public List<Customer> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customers", Customer.class);
        return customerQuery.getResultList();
    }

    public Hotel get(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }
}
*/
