package com.bobwares.demo.swagger.service;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;

public interface CustomerService {
    Iterable<Customer> getCustomers();

    Customer getCustomer(long id);

    Customer postCustomer(CustomerInDto customerInDto);

}
