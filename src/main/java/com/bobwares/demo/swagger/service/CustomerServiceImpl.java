package com.bobwares.demo.swagger.service;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;
import com.bobwares.demo.swagger.repository.CustomerRepository;
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
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public Customer postCustomer(CustomerInDto customerInDto) {
        Customer customer = Customer.builder()
                .firstName(customerInDto.getFirstName())
                .lastName(customerInDto.getLastName())
                .build();
        return customerRepository.save(customer);
    }
}
