package com.devcamp.project_real_estate_exchange.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.devcamp.project_real_estate_exchange.entity.Investor;
import com.devcamp.project_real_estate_exchange.entity.Employee;
import com.devcamp.project_real_estate_exchange.entity.Investor;
import com.devcamp.project_real_estate_exchange.res.IInvestorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
public class InvestorController {
    @Autowired
    IInvestorRepository iInvestorRepository;

    @GetMapping("/investors")
    public List getMethodName() {
        return this.iInvestorRepository.findAll();
    }

    @GetMapping("/investors/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Investor> gOptional = this.iInvestorRepository.findById(id);
        if (gOptional.isPresent()) {
            Investor gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/investors")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Investor entity) {

        // TODO: process POST request
        Investor investor = new Investor();
        investor.setAddress(entity.getAddress());
        investor.setDescription(entity.getDescription());
        investor.setEmail(entity.getEmail());
        investor.setFax(entity.getFax());
        investor.setName(entity.getName());
        investor.setPhone(entity.getPhone());
        investor.setPhone2(entity.getPhone2());
        investor.setProjects(entity.getProjects());
        investor.setWebsite(entity.getWebsite());

        iInvestorRepository.save(investor);

        return new ResponseEntity<>(investor, HttpStatus.CREATED);
    }

    @PutMapping("/investors/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Investor entity) {
        // TODO: process PUT request
        Optional<Investor> uOptional = this.iInvestorRepository.findById(id);
        if (uOptional.isPresent()) {
            Investor investor = uOptional.get();

            investor.setAddress(entity.getAddress());
            investor.setDescription(entity.getDescription());
            investor.setEmail(entity.getEmail());
            investor.setFax(entity.getFax());
            investor.setName(entity.getName());
            investor.setPhone(entity.getPhone());
            investor.setPhone2(entity.getPhone2());
            investor.setProjects(entity.getProjects());
            investor.setWebsite(entity.getWebsite());

            iInvestorRepository.save(investor);

            return new ResponseEntity<>(investor, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/investors/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Investor> dOptional = this.iInvestorRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iInvestorRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
