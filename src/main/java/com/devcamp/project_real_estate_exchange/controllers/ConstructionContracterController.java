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

import com.devcamp.project_real_estate_exchange.entity.ConstructionContracter;
import com.devcamp.project_real_estate_exchange.res.IConstructionContracterRepositoty;

@RestController
@CrossOrigin
public class ConstructionContracterController {
    @Autowired
    IConstructionContracterRepositoty iConstructionContracterRepositoty;

    @GetMapping("/constructionContracters")
    public List getMethodName() {
        return this.iConstructionContracterRepositoty.findAll();
    }

    @GetMapping("/constructionContracters/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id)
            throws InternalServerError {
        Optional<ConstructionContracter> gOptional = iConstructionContracterRepositoty.findById(id);
        if (gOptional.isPresent()) {
            ConstructionContracter gId = gOptional.get();
            
            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/constructionContracters")
    public ResponseEntity<Object> postMethodName(@Valid
            @RequestBody ConstructionContracter entity) throws InternalServerError {

        // TODO: process POST request
        ConstructionContracter constructionContracter = new ConstructionContracter();
        constructionContracter.setName(entity.getName());
        constructionContracter.setDescription(entity.getDescription());
        constructionContracter.setProjects(entity.getProjects());
        constructionContracter.setAddress(entity.getAddress());
        constructionContracter.setPhone(entity.getPhone());
        constructionContracter.setPhone2(entity.getPhone2());
        constructionContracter.setFax(entity.getFax());
        constructionContracter.setEmail(entity.getEmail());
        constructionContracter.setWebsite(entity.getWebsite());

        iConstructionContracterRepositoty.save(constructionContracter);

        return new ResponseEntity<>(constructionContracter, HttpStatus.CREATED);
    }

    @PutMapping("/constructionContracters/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id,
            @RequestBody ConstructionContracter entity) throws InternalServerError {

        // TODO: process PUT request
        Optional<ConstructionContracter> uOptional = this.iConstructionContracterRepositoty.findById(id);
        if (uOptional.isPresent()) {
            ConstructionContracter constructionContracter = uOptional.get();
            constructionContracter.setName(entity.getName());
            constructionContracter.setDescription(entity.getDescription());
            constructionContracter.setProjects(entity.getProjects());
            constructionContracter.setAddress(entity.getAddress());
            constructionContracter.setPhone(entity.getPhone());
            constructionContracter.setPhone2(entity.getPhone2());
            constructionContracter.setFax(entity.getFax());
            constructionContracter.setEmail(entity.getEmail());
            constructionContracter.setWebsite(entity.getWebsite());

            iConstructionContracterRepositoty.save(constructionContracter);

            return new ResponseEntity<>(constructionContracter, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/constructionContracters/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<ConstructionContracter> dOptional = this.iConstructionContracterRepositoty.findById(id);
        if (dOptional.isPresent()) {
            this.iConstructionContracterRepositoty.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
