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

import com.devcamp.project_real_estate_exchange.entity.District;
import com.devcamp.project_real_estate_exchange.entity.Employee;
import com.devcamp.project_real_estate_exchange.entity.Province;
import com.devcamp.project_real_estate_exchange.entity.Ward;
import com.devcamp.project_real_estate_exchange.res.IDistrictRepository;
import com.devcamp.project_real_estate_exchange.res.IEmployeeRepository;
import com.devcamp.project_real_estate_exchange.res.IProvinceRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

import com.devcamp.project_real_estate_exchange.res.IWardRepository;

@RestController
@CrossOrigin
public class WardController {
    @Autowired
    IWardRepository iWardRepository;

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Autowired
    IProvinceRepository iProvinceRepository;

    @GetMapping("/wards")
    public List getMethodName() {
        return this.iWardRepository.findAll();
    }

    @GetMapping("/wards/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Ward> gOptional = this.iWardRepository.findById(id);
        if (gOptional.isPresent()) {
            Ward gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/wards/{id1}/{id}")
    public ResponseEntity<Object> postMethodName(@Valid @PathVariable int id1 ,@PathVariable int id, @RequestBody Ward entity)
            throws InternalServerError {
        Optional<District> cOptinal = this.iDistrictRepository.findById(id1);
        Optional<Province> cOptinal1 = this.iProvinceRepository.findById(id);
        if (cOptinal.isPresent() && cOptinal1.isPresent()) {
            // TODO: process POST request
            Ward ward = new Ward();
            ward.setName(entity.getName());
            ward.setPrefix(entity.getPrefix());
            

            iWardRepository.save(ward);

            return new ResponseEntity<>(ward, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/wards/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Ward entity)
            throws InternalServerError {
        // TODO: process PUT request
        Optional<Ward> uOptional = this.iWardRepository.findById(id);
        if (uOptional.isPresent()) {
            Ward ward = uOptional.get();
            ward.setName(entity.getName());
            ward.setPrefix(entity.getPrefix());

            iWardRepository.save(ward);

            return new ResponseEntity<>(ward, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/wards/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Ward> dOptional = this.iWardRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iWardRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
