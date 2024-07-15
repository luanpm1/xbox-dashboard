package com.devcamp.project_real_estate_exchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.devcamp.project_real_estate_exchange.entity.Employee;
import com.devcamp.project_real_estate_exchange.entity.Street;
import com.devcamp.project_real_estate_exchange.res.IEmployeeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.devcamp.project_real_estate_exchange.res.IStreetRepository;

@RestController
@CrossOrigin
public class StreetController {
    @Autowired
    IStreetRepository iStreetRepository;

    @GetMapping("/streets")
    public List getMethodName() {
        return this.iStreetRepository.findAll();
    }

    @GetMapping("/streets/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Street> gOptional = this.iStreetRepository.findById(id);
        if (gOptional.isPresent()) {
            Street gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/streets")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Street entity) throws InternalServerError {

        // TODO: process POST request
        Street street = new Street();
        street.setName(entity.getName());
        street.setPrefix(entity.getPrefix());

        iStreetRepository.save(street);

        return new ResponseEntity<>(street, HttpStatus.CREATED);
    }

    @PutMapping("/streets/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Street entity)
            throws InternalServerError {
        // TODO: process PUT request
        Optional<Street> uOptional = this.iStreetRepository.findById(id);
        if (uOptional.isPresent()) {
            Street street = uOptional.get();
            street.setName(entity.getName());
            street.setPrefix(entity.getPrefix());

            iStreetRepository.save(street);

            return new ResponseEntity<>(street, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/streets/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Street> dOptional = this.iStreetRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iStreetRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
