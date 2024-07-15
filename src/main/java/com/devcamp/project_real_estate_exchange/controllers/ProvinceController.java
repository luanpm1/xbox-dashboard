package com.devcamp.project_real_estate_exchange.controllers;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;
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

import com.devcamp.project_real_estate_exchange.entity.Province;
import com.devcamp.project_real_estate_exchange.res.IProvinceRepository;

@RestController
@CrossOrigin
public class ProvinceController {
    @Autowired
    IProvinceRepository iProvinceRepository;

    @GetMapping("/provinces")
    public List getMethodName() {
        return this.iProvinceRepository.findAll();

    }

    @GetMapping("/provinces/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Province> gOptional = iProvinceRepository.findById(id);
        if (gOptional.isPresent()) {
            Province gId = gOptional.get();

            return new ResponseEntity<>(gOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/provinces")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Province entity) throws InternalServerError {

        // TODO: process POST request
        Province province = new Province();
        province.setCode(entity.getCode());
        province.setDistricts(entity.getDistricts());
        province.setName(entity.getName());

        iProvinceRepository.save(province);

        return new ResponseEntity<>(province, HttpStatus.CREATED);
    }

    @PutMapping("/provinces/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Province entity)
            throws InternalServerError {
        // TODO: process PUT request
        Optional<Province> uOptional = this.iProvinceRepository.findById(id);
        if (uOptional.isPresent()) {
            Province province = uOptional.get();
            province.setCode(entity.getCode());
            province.setDistricts(entity.getDistricts());
            province.setName(entity.getName());

            iProvinceRepository.save(province);

            return new ResponseEntity<>(province, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/provinces/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Province> dOptional = this.iProvinceRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iProvinceRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
