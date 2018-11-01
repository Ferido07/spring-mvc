package com.fyzapps.springmvc.services;

import com.fyzapps.springmvc.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveOrUpdate(Customer customer);

    void deleteCustomer(Integer id);
}
