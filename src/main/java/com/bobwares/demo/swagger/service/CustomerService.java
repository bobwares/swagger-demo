package com.bobwares.demo.swagger.service;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;

public interface CustomerService {
    Iterable<Customer> getCustomers();

    Customer getCustomer(int id);

    Customer postCustomer(CustomerInDto customerInDto);

}
