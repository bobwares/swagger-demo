package com.bobwares.demo.swagger.service;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;
import com.bobwares.demo.swagger.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer get(long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer post(CustomerInDto customerInDto) {
        Customer customer = Customer.builder()
                .firstName(customerInDto.getFirstName())
                .lastName(customerInDto.getLastName())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public Customer put(CustomerInDto customerInDto, long id) {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            return null;
        } else {
            customer.setFirstName(customerInDto.getFirstName());
            customer.setLastName(customerInDto.getLastName());
            return customerRepository.save(customer);
        }

    }

    @Override
    public void delete(long id) {
        customerRepository.delete(id);
    }
}