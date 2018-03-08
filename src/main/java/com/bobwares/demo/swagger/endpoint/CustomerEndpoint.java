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
    public ResponseEntity<Customer> get(@PathVariable("id") long id) {
        Customer customer = customerService.get(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PostMapping("customer")
    public Customer post(@RequestBody CustomerInDto customerInDto) {
        return customerService.post(customerInDto);
    }

    @PutMapping("customer/{id}")
    public ResponseEntity<Customer> put(@PathVariable("id") long id, @RequestBody CustomerInDto customerInDto) {
        Customer updatedCustomer = customerService.put(customerInDto, id);
        if (updatedCustomer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        ResponseEntity<Customer> customerResponseEntity = new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
        return customerResponseEntity;
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        customerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
