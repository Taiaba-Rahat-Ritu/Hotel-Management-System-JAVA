package dev.rest;
import dev.domain.Customer;

import dev.domain.Hotel;
import dev.service.CustomerService;

import dev.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getSpecificCustomer(@PathVariable("customerId") Integer customerId) {
        return customerService.get(customerId);
    }

    @PutMapping("/customers/{customerId}")
    public String UpdateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer) {

        customerService.edit(customer);
        return "Successful Customer Updated";
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.delete(customerId);
        return "Successful";
    }

    @PostMapping("/customers")
    public String createCustomer(@RequestBody Customer customer) {
        customerService.create(customer);
        return "Successful";
    }
}
