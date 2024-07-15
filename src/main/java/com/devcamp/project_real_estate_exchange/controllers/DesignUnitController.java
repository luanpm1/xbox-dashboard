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

import com.devcamp.project_real_estate_exchange.entity.DesignUnit;
import com.devcamp.project_real_estate_exchange.res.IDesignUnitRepository;

@RestController
@CrossOrigin
public class DesignUnitController {
    @Autowired
    IDesignUnitRepository iDesignUnitRepository;

    // get list design unit
    @GetMapping("/design_units")
    public List getMethodName() {
        return this.iDesignUnitRepository.findAll();
    }

    // get desing by id
    @GetMapping("/design_units/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<DesignUnit> gOptional = iDesignUnitRepository.findById(id);

        return new ResponseEntity<>(gOptional.get(), HttpStatus.OK);
    }

    // create design unit
    @PostMapping("/design_units")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody DesignUnit entity) throws InternalServerError {

        // TODO: process POST request
        DesignUnit designUnit = new DesignUnit();
        
        designUnit.setName(entity.getName());
        designUnit.setDescription(entity.getDescription());
        designUnit.setProjects(entity.getProjects());
        designUnit.setAddress(entity.getAddress());
        designUnit.setPhone(entity.getPhone());
        designUnit.setPhone2(entity.getPhone2());
        designUnit.setFax(entity.getFax());
        designUnit.setEmail(entity.getEmail());
        designUnit.setWebsite(entity.getWebsite());

        iDesignUnitRepository.save(designUnit);

        return new ResponseEntity<>(designUnit, HttpStatus.CREATED);
    }

    // update design unit
    @PutMapping("/design_units/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody DesignUnit entity)
            throws InternalServerError {

        // TODO: process PUT request
        Optional<DesignUnit> uOptional = this.iDesignUnitRepository.findById(id);
        if (uOptional.isPresent()) {
            DesignUnit designUnit = uOptional.get();
            designUnit.setName(entity.getName());
            designUnit.setDescription(entity.getDescription());
            designUnit.setProjects(entity.getProjects());
            designUnit.setAddress(entity.getAddress());
            designUnit.setPhone(entity.getPhone());
            designUnit.setPhone2(entity.getPhone2());
            designUnit.setFax(entity.getFax());
            designUnit.setEmail(entity.getEmail());
            designUnit.setWebsite(entity.getWebsite());

            // save vao repositoty
            iDesignUnitRepository.save(designUnit);

            return new ResponseEntity<>(designUnit, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete design unit
    @DeleteMapping("/design_units/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<DesignUnit> dOptional = this.iDesignUnitRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iDesignUnitRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
