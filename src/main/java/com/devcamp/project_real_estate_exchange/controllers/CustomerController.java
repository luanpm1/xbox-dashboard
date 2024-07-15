package com.devcamp.project_real_estate_exchange.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.devcamp.project_real_estate_exchange.entity.Customer;

import com.devcamp.project_real_estate_exchange.res.ICustomerRepository;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @GetMapping("/customers")
    public List getMethodName() {
        return this.iCustomerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable int id) throws InternalServerError {
        Optional<Customer> gOptional = iCustomerRepository.findById(id);
        if (gOptional.isPresent()) {
            return new ResponseEntity<>(gOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/customers")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Customer entity) {

        // TODO: process POST request
        Customer customer = new Customer();
        customer.setContactName(entity.getContactName());
        customer.setContactTitle(entity.getContactTitle());
        customer.setAddress(entity.getAddress());
        customer.setMobile(entity.getMobile());
        customer.setEmail(entity.getEmail());
        customer.setNote(entity.getNote());
        customer.setCreateBy(entity.getCreateBy());
        // customer.setUpdatesBy(entity.getUpdateBy());
        customer.setCreateDate(new Date());
        // customer.setUpdateDate(new Date());

        iCustomerRepository.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Customer entity) {
        // TODO: process PUT request
        Optional<Customer> uOptional = iCustomerRepository.findById(id);
        if (uOptional.isPresent()) {
            Customer customer = uOptional.get();
            customer.setContactName(entity.getContactName());
            customer.setContactTitle(entity.getContactTitle());
            customer.setAddress(entity.getAddress());
            customer.setMobile(entity.getMobile());
            customer.setEmail(entity.getEmail());
            customer.setNote(entity.getNote());
            // customer.setCreateBy(entity.getCreateBy());
            customer.setUpdateBy(entity.getUpdateBy());
            // customer.setCreateDate(new Date());
            customer.setUpdateDate(new Date());

            iCustomerRepository.save(customer);

            return new ResponseEntity<>(customer, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Customer> dOptional = iCustomerRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iCustomerRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // @DeleteMapping("/customers")
    // public ResponseEntity<Customer> deleteDeparments() throws
    // InternalServerError{
    // this.iCustomerRepository.deleteAll();
    // return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    // }
}
