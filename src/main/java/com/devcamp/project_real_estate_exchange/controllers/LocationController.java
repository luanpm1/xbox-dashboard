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

import com.devcamp.project_real_estate_exchange.entity.Employee;
import com.devcamp.project_real_estate_exchange.entity.Location;
import com.devcamp.project_real_estate_exchange.res.ILocationRepository;

@RestController
@CrossOrigin
public class LocationController {
    @Autowired
    ILocationRepository iLocationRepository;

    @GetMapping("/locations")
    public List getMethodName() {
        return this.iLocationRepository.findAll();
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Location> gOptional = this.iLocationRepository.findById(id);
        if (gOptional.isPresent()) {
            Location gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/locations")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Location entity) {

        // TODO: process POST request
        Location location = new Location();
        location.setLatitude(entity.getLatitude());
        location.setLongitude(entity.getLongitude());

        iLocationRepository.save(location);

        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Location entity) {
        // TODO: process PUT request
        Optional<Location> uOptional = this.iLocationRepository.findById(id);
        if (uOptional.isPresent()) {
            Location location = uOptional.get();
            location.setLatitude(entity.getLatitude());
            location.setLongitude(entity.getLongitude());

            iLocationRepository.save(location);

            return new ResponseEntity<>(location, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Location> dOptional = this.iLocationRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iLocationRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
