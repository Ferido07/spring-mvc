package com.fyzapps.springmvc.controllers;

import com.fyzapps.springmvc.models.Customer;
import com.fyzapps.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"","/list"})
    public String listAllCustomers(Model model){
        model.addAttribute("customers",customerService.getAllCustomers());
        return "customer/list";
    }

    @RequestMapping("/{id}")
    public String getCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "customer/customer";
    }

    @RequestMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/customerForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrUpdate(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdate(customer);
        return "redirect:/customers/" + savedCustomer.getId();
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "customer/customerForm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
