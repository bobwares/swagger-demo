package com.bobwares.demo.swagger.endpoint;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;
import com.bobwares.demo.swagger.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping("customer")
    public Customer put(CustomerInDto customerInDto) {
        return customerService.postCustomer(customerInDto);
    }
}
