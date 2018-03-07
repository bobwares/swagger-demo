package com.bobwares.demo.swagger.repository;

import com.bobwares.demo.swagger.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}