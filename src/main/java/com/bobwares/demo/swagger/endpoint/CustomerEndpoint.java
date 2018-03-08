package com.bobwares.demo.swagger.endpoint;

import com.bobwares.demo.swagger.dto.CustomerInDto;
import com.bobwares.demo.swagger.entity.Customer;
import com.bobwares.demo.swagger.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "customer", description = "The customer API")
@RestController
public class CustomerEndpoint {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Get a listing of all customers.",
            notes = "Class: CustomerEndpoint, Method: getAll")
    @GetMapping("customer")
    public Iterable<Customer> getAll() {
        return customerService.getAll();
    }

    @ApiOperation(value = "Get a customers by id.",
            notes = "Class: CustomerEndpoint, Method: get")
    @GetMapping("customer/{id}")
    public ResponseEntity<Customer> get(
            @ApiParam(value = "Unique id that identifies the Customer record.",
                    required = true)
            @PathVariable("id") long id) {
        Customer customer = customerService.get(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @ApiOperation(value = "Create a new Customer record.",
            notes = "Class: CustomerEndpoint, Method: post")
    @PostMapping("customer")
    public Customer post(@RequestBody CustomerInDto customerInDto) {
        return customerService.post(customerInDto);
    }


    @ApiOperation(value = "Update a new Customer record.",
            notes = "Class: CustomerEndpoint, Method: put")
    @PutMapping("customer/{id}")
    public ResponseEntity<Customer> put(
            @ApiParam(value = "Unique id that identifies the Customer record.",
                    required = true)
            @PathVariable("id") long id, @RequestBody CustomerInDto customerInDto) {
        Customer updatedCustomer = customerService.put(customerInDto, id);
        if (updatedCustomer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        ResponseEntity<Customer> customerResponseEntity = new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
        return customerResponseEntity;
    }


    @ApiOperation(value = "Delete a Customer record.",
            notes = "Class: CustomerEndpoint, Method: delete")
    @DeleteMapping("customer/{id}")
    public ResponseEntity<HttpStatus> delete(
            @ApiParam(value = "Unique id that identifies the Customer record.",
                    required = true)
            @PathVariable("id") long id) {
        customerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
