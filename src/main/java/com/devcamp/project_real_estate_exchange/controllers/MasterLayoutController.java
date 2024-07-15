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

import com.devcamp.project_real_estate_exchange.entity.Employee;
import com.devcamp.project_real_estate_exchange.entity.MasterLayout;
import com.devcamp.project_real_estate_exchange.res.IMasterLayoutRepository;

@RestController
@CrossOrigin
public class MasterLayoutController {
    @Autowired
    IMasterLayoutRepository iMasterLayoutRepository;

    @GetMapping("/masterLayouts")
    public List getMethodName() {
        return this.iMasterLayoutRepository.findAll();
    }

    @GetMapping("/masterLayouts/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<MasterLayout> gOptional = this.iMasterLayoutRepository.findById(id);
        if (gOptional.isPresent()) {
            MasterLayout gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/masterLayouts")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody MasterLayout entity) {

        // TODO: process POST request
        MasterLayout masterLayout = new MasterLayout();
        masterLayout.setAcreage(entity.getAcreage());
        masterLayout.setApartmentList(entity.getApartmentList());
        masterLayout.setDateCreate(new Date());
        masterLayout.setDateUpdate(entity.getDateUpdate());
        masterLayout.setDescription(entity.getDescription());
        masterLayout.setName(entity.getName());
        masterLayout.setPhoto(entity.getPhoto());

        iMasterLayoutRepository.save(masterLayout);

        return new ResponseEntity<>(masterLayout, HttpStatus.CREATED);
    }

    @PutMapping("/masterLayouts/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody MasterLayout entity) {
        // TODO: process PUT request
        Optional<MasterLayout> uOptional = this.iMasterLayoutRepository.findById(id);
        if (uOptional.isPresent()) {
            MasterLayout masterLayout = uOptional.get();
            masterLayout.setAcreage(entity.getAcreage());
            masterLayout.setApartmentList(entity.getApartmentList());
            // masterLayout.setDateCreate(new Date());
            masterLayout.setDateUpdate(new Date());
            masterLayout.setDescription(entity.getDescription());
            masterLayout.setName(entity.getName());
            masterLayout.setPhoto(entity.getPhoto());

            iMasterLayoutRepository.save(masterLayout);

            return new ResponseEntity<>(masterLayout, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/masterLayouts/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<MasterLayout> dOptional = this.iMasterLayoutRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iMasterLayoutRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
