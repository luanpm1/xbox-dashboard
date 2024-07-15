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
import com.devcamp.project_real_estate_exchange.entity.RegionLink;
import com.devcamp.project_real_estate_exchange.res.IRegionLinkRepository;

@RestController
@CrossOrigin
public class RegionLinkController {
    @Autowired
    IRegionLinkRepository iRegionLinkRepository;

    @GetMapping("/regionLinks")
    public List getMethodName() {
        return this.iRegionLinkRepository.findAll();
    }

    @GetMapping("/regionLinks/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<RegionLink> gOptional = this.iRegionLinkRepository.findById(id);
        if (gOptional.isPresent()) {
            RegionLink gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regionLinks")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody RegionLink entity) {

        // TODO: process POST request
        RegionLink regionLink = new RegionLink();
        regionLink.setAddress(entity.getAddress());
        regionLink.setDescription(entity.getDescription());
        regionLink.setName(entity.getName());
        regionLink.setPhoto(entity.getPhoto());
        regionLink.set_lat(entity.get_lat());
        regionLink.set_lng(entity.get_lng());

        iRegionLinkRepository.save(regionLink);

        return new ResponseEntity<>(regionLink, HttpStatus.CREATED);
    }

    @PutMapping("/regionLinks/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody RegionLink entity) {
        // TODO: process PUT request
        Optional<RegionLink> uOptional = this.iRegionLinkRepository.findById(id);
        if (uOptional.isPresent()) {
            RegionLink regionLink = uOptional.get();
            regionLink.setAddress(entity.getAddress());
            regionLink.setDescription(entity.getDescription());
            regionLink.setName(entity.getName());
            regionLink.setPhoto(entity.getPhoto());
            regionLink.set_lat(entity.get_lat());
            regionLink.set_lng(entity.get_lng());

            iRegionLinkRepository.save(regionLink);

            return new ResponseEntity<>(regionLink, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/regionLinks/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<RegionLink> dOptional = this.iRegionLinkRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iRegionLinkRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
