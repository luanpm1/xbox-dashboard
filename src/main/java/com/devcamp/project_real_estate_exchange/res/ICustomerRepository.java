package com.devcamp.project_real_estate_exchange.res;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devcamp.project_real_estate_exchange.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>  {
    
}
