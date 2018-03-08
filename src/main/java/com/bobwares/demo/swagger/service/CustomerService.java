package com.bobwares.demo.swagger.service;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;

public interface CustomerService {

    Iterable<Customer> getAll();

    Customer get(long id);

    Customer post(CustomerInDto customerInDto);

    Customer put(CustomerInDto customerInDto, long id);

    void delete(long id);
}