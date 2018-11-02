package com.fyzapps.springmvc.services;

import com.fyzapps.springmvc.domain.Customer;
import com.fyzapps.springmvc.domain.DomainObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl extends  AbstractMapService implements CustomerService {

    @Override
    public void loadDomainObjects() {
        map = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Ferid");
        customer1.setLastName("Zuber");
        map.put(1,customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Customer");
        customer2.setLastName("2");
        map.put(2,customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Customer");
        customer3.setLastName("3");
        map.put(3,customer3);
    }

    @Override
    public List<DomainObject> getAll(){
        return super.listAll();
    }
    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
       return (Customer) super.saveOrUpdate(customer);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
