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
import com.devcamp.project_real_estate_exchange.entity.Project;
import com.devcamp.project_real_estate_exchange.res.IProjectRepository;

@RestController
@CrossOrigin
public class ProjectController {
    @Autowired
    IProjectRepository iProjectRepository;

    @GetMapping("/projects")
    public List getMethodName() {
        return this.iProjectRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Project> gOptional = this.iProjectRepository.findById(id);
        if (gOptional.isPresent()) {
            Project gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/projects")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Project entity) {

        // TODO: process POST request
        Project project = new Project();
        project.setAcreage(entity.getAcreage());
        project.setApartmentArea(entity.getApartmentArea());
        project.setConstructArea(entity.getConstructArea());
        project.setConstructionContractor(entity.getConstructionContractor());
        project.setDescription(entity.getDescription());
        project.setDesignUnit(entity.getDesignUnit());
        project.setInvestor(entity.getInvestor());
        project.setName(entity.getName());
        project.setNumApartment(entity.getNumApartment());
        project.setNumBlock(entity.getNumBlock());
        project.setNumFloors(entity.getNumFloors());
        project.setPhoto(entity.getPhoto());
        project.setRegionLink(entity.getRegionLink());
        project.setSlogan(entity.getSlogan());
        project.setUtilities(entity.getUtilities());
        project.set_lat(entity.get_lat());
        project.set_lng(entity.get_lng());

        iProjectRepository.save(project);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Project entity) {
        // TODO: process PUT request
        Optional<Project> uOptional = this.iProjectRepository.findById(id);
        if (uOptional.isPresent()) {
            Project project = uOptional.get();
            project.setAcreage(entity.getAcreage());
            project.setApartmentArea(entity.getApartmentArea());
            project.setConstructArea(entity.getConstructArea());
            project.setConstructionContractor(entity.getConstructionContractor());
            project.setDescription(entity.getDescription());
            project.setDesignUnit(entity.getDesignUnit());
            project.setInvestor(entity.getInvestor());
            project.setName(entity.getName());
            project.setNumApartment(entity.getNumApartment());
            project.setNumBlock(entity.getNumBlock());
            project.setNumFloors(entity.getNumFloors());
            project.setPhoto(entity.getPhoto());
            project.setRegionLink(entity.getRegionLink());
            project.setSlogan(entity.getSlogan());
            project.setUtilities(entity.getUtilities());
            project.set_lat(entity.get_lat());
            project.set_lng(entity.get_lng());

            iProjectRepository.save(project);

            return new ResponseEntity<>(project, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Project> dOptional = this.iProjectRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iProjectRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
