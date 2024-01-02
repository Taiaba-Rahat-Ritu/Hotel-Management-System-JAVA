package dev.service;

import dev.domain.Customer;
import dev.domain.Hotel;
import dev.repository.CustomerRepository;

import dev.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
    }

    public void create(Customer customer) {
        customer.setFirstName(customer.getFirstName().toUpperCase());
        customerRepository.create(customer);
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    public Customer get(int customerId) {
        return customerRepository.get(customerId);
    }
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }


    public void delete(int customerId) {
        customerRepository.delete(customerId);
    }

}
