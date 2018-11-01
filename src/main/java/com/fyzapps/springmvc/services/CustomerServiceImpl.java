package com.fyzapps.springmvc.services;

import com.fyzapps.springmvc.models.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private HashMap<Integer,Customer> customers;

    public CustomerServiceImpl() {
        this.customers = loadCustomers();
    }

    private HashMap<Integer,Customer> loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Ferid");
        customer1.setLastName("Zuber");
        customers.put(1,customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Customer");
        customer2.setLastName("2");
        customers.put(2,customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Customer");
        customer3.setLastName("3");
        customers.put(3,customer3);

        return customers;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        if (customer != null){
            if(customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(),customer);
            return customer;
        }
        else throw new RuntimeException("Customer cannot be null.");
    }

    private Integer getNextKey() {
        return Collections.max(customers.keySet()) + 1;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }
}
