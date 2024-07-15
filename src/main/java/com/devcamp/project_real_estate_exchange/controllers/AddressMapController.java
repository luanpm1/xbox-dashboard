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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.devcamp.project_real_estate_exchange.entity.AddressMap;
import com.devcamp.project_real_estate_exchange.res.IAddressMapRepository;

@RestController
@CrossOrigin
public class AddressMapController {
    @Autowired
    IAddressMapRepository iAddressMapRepository;

    @GetMapping("/addressmaps")
    public List getMethodName() {
        return this.iAddressMapRepository.findAll();
    }

    @GetMapping("/addressmaps/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<AddressMap> gOptional = this.iAddressMapRepository.findById(id);
        if (gOptional.isPresent()) {
            return new ResponseEntity<>(gOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addressmaps")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody AddressMap entity) throws InternalServerError {

        // TODO: process POST request
        AddressMap addressMap = new AddressMap();
        addressMap.setAddress(entity.getAddress());
        addressMap.set_lat(entity.get_lat());
        addressMap.set_lng(entity.get_lng());

        iAddressMapRepository.save(addressMap);

        return new ResponseEntity<>(addressMap, HttpStatus.CREATED);
    }

    @PutMapping("/addressmaps/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody AddressMap entity)
            throws InternalServerError {

        // TODO: process PUT request
        Optional<AddressMap> uOptional = iAddressMapRepository.findById(id);
        if (uOptional.isPresent()) {
            AddressMap addressMap = uOptional.get();
            addressMap.setAddress(entity.getAddress());
            addressMap.set_lat(entity.get_lat());
            addressMap.set_lng(entity.get_lng());

            iAddressMapRepository.save(addressMap);

            return new ResponseEntity<>(addressMap, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/addressmaps/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        
        Optional<AddressMap> dOptional = iAddressMapRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iAddressMapRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
