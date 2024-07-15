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


import com.devcamp.project_real_estate_exchange.entity.Realestate;
import com.devcamp.project_real_estate_exchange.res.IRealestateRepository;

@RestController
@CrossOrigin
public class RealestateController {
    @Autowired
    IRealestateRepository iRealestateRepository;

    @GetMapping("/realestates")
    public List getMethodName() {
        return this.iRealestateRepository.findAll();
    }

    @GetMapping("/realestates/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Realestate> gOptional = this.iRealestateRepository.findById(id);
        if (gOptional.isPresent()) {
            Realestate gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/realestates")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Realestate entity) {

        // TODO: process POST request
        Realestate realestate = new Realestate();
        realestate.setAcreage(entity.getAcreage());
        realestate.setAddress(entity.getAddress());
        realestate.setApartmentCode(entity.getApartmentCode());
        realestate.setApartmentLocal(entity.getApartmentLocal());
        realestate.setApartmentType(entity.getApartmentType());
        realestate.setBathroom(entity.getBathroom());
        realestate.setBedroom(entity.getBedroom());
        realestate.setCreateBy(entity.getCreateBy());
        realestate.setDateCreate(new Date());
        realestate.setDescription(entity.getDescription());
        realestate.setDirection(entity.getDirection());
        realestate.setFactor(entity.getFactor());
        realestate.setFurnitureType(entity.getFurnitureType());
        realestate.setLandscapeView(entity.getLandscapeView());
        realestate.setLegalDoc(entity.getLegalDoc());
        realestate.setNumberFloors(entity.getNumberFloors());
        realestate.setPhoto(entity.getPhoto());
        realestate.setPrice(entity.getPrice());
        realestate.setPriceRent(entity.getPriceRent());
        realestate.setRequest(entity.getRequest());
        realestate.setStreetHouse(entity.getStreetHouse());
        realestate.setStructure(entity.getStructure());
        realestate.setTitle(entity.getTitle());
        realestate.setTotalFloors(entity.getTotalFloors());
        realestate.setType(entity.getType());
        realestate.setUpdateBy(entity.getUpdateBy());
        realestate.setViewNum(entity.getViewNum());
        realestate.setWallArea(entity.getWallArea());
        realestate.set_lat(entity.get_lat());
        realestate.set_lng(entity.get_lng());
        realestate.set_long(entity.get_long());
        realestate.set_width(entity.get_width());

        iRealestateRepository.save(realestate);

        return new ResponseEntity<>(realestate, HttpStatus.CREATED);
    }

    @PutMapping("/realestates/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Realestate entity) {
        // TODO: process PUT request
        Optional<Realestate> uOptional = this.iRealestateRepository.findById(id);
        if (uOptional.isPresent()) {
            Realestate realestate = uOptional.get();
            realestate.setAcreage(entity.getAcreage());
            realestate.setAddress(entity.getAddress());
            realestate.setApartmentCode(entity.getApartmentCode());
            realestate.setApartmentLocal(entity.getApartmentLocal());
            realestate.setApartmentType(entity.getApartmentType());
            realestate.setBathroom(entity.getBathroom());
            realestate.setBedroom(entity.getBedroom());
            realestate.setCreateBy(entity.getCreateBy());
            // realestate.setDateCreate(new Date());
            realestate.setDescription(entity.getDescription());
            realestate.setDirection(entity.getDirection());
            realestate.setFactor(entity.getFactor());
            realestate.setFurnitureType(entity.getFurnitureType());
            realestate.setLandscapeView(entity.getLandscapeView());
            realestate.setLegalDoc(entity.getLegalDoc());
            realestate.setNumberFloors(entity.getNumberFloors());
            realestate.setPhoto(entity.getPhoto());
            realestate.setPrice(entity.getPrice());
            realestate.setPriceRent(entity.getPriceRent());
            realestate.setRequest(entity.getRequest());
            realestate.setStreetHouse(entity.getStreetHouse());
            realestate.setStructure(entity.getStructure());
            realestate.setTitle(entity.getTitle());
            realestate.setTotalFloors(entity.getTotalFloors());
            realestate.setType(entity.getType());
            realestate.setUpdateBy(entity.getUpdateBy());
            realestate.setViewNum(entity.getViewNum());
            realestate.setWallArea(entity.getWallArea());
            realestate.set_lat(entity.get_lat());
            realestate.set_lng(entity.get_lng());
            realestate.set_long(entity.get_long());
            realestate.set_width(entity.get_width());

            iRealestateRepository.save(realestate);

            return new ResponseEntity<>(realestate, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/realestates/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Realestate> dOptional = this.iRealestateRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iRealestateRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
