package com.bobwares.demo.swagger.endpoint;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;
import com.bobwares.demo.swagger.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerEndpoint {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer")
    public Iterable<Customer> getAll() {
        return customerService.getCustomers();
    }

    @GetMapping("customer/{id}")
    public Customer get(@PathVariable("id") long id) {
        return customerService.getCustomer(id);
    }

    @PutMapping("customer")
    public Customer post(@RequestBody CustomerInDto customerInDto) {
        return customerService.postCustomer(customerInDto);
    }

//    @PutMapping("customer")
//    public Customer put(Customer customer) {
//        return customerService.postCustomer(customerInDto);
//    }
}
