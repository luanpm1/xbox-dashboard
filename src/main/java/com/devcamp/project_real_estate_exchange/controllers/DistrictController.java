package com.devcamp.project_real_estate_exchange.controllers;

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
import com.devcamp.project_real_estate_exchange.entity.Province;
import com.devcamp.project_real_estate_exchange.res.IDistrictRepository;
import com.devcamp.project_real_estate_exchange.res.IProvinceRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
public class DistrictController {
    @Autowired
    IDistrictRepository iDistrictRepository;

    @Autowired
    IProvinceRepository iProvinceRepository;

    @GetMapping("/districts")
    public List getMethodName() {
        return this.iDistrictRepository.findAll();
    }

    @GetMapping("/districts/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<District> gOptional = this.iDistrictRepository.findById(id);
        if (gOptional.isPresent()) {
            District gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/districts/{id}")
    public ResponseEntity<Object> postMethodName(@Valid @PathVariable int id, @RequestBody District entity)
            throws InternalServerError {
        Optional<Province> cOptional = this.iProvinceRepository.findById(id);
        if (cOptional.isPresent()) {
            // TODO: process POST request
            District district = new District();
            district.setName(entity.getName());
            district.setPrefix(entity.getPrefix());
            district.setWards(entity.getWards());

            iDistrictRepository.save(district);

            return new ResponseEntity<>(district, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/districts/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody District entity)
            throws InternalServerError {
        // TODO: process PUT request
        Optional<District> uOptional = this.iDistrictRepository.findById(id);
        if (uOptional.isPresent()) {
            District district = uOptional.get();
            district.setName(entity.getName());
            district.setPrefix(entity.getPrefix());

            iDistrictRepository.save(district);

            return new ResponseEntity<>(district, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/districts/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<District> dOptional = this.iDistrictRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iDistrictRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
