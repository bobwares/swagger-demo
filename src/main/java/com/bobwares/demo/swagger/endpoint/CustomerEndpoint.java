package com.bobwares.demo.swagger.endpoint;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;
import com.bobwares.demo.swagger.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return customerService.getAll();
    }

    @GetMapping("customer/{id}")
    public Customer get(@PathVariable("id") long id) {
        return customerService.get(id);
    }

    @PostMapping("customer")
    public Customer post(@RequestBody CustomerInDto customerInDto) {
        return customerService.post(customerInDto);
    }

    @PutMapping("customer")
    public ResponseEntity<Customer> put(Customer customer) {
        Customer updatedCustomer = customerService.put(customer);
        ResponseEntity<Customer> customerResponseEntity = new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
        return customerResponseEntity;
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
