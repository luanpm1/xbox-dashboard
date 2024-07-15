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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.devcamp.project_real_estate_exchange.entity.Employee;
import com.devcamp.project_real_estate_exchange.res.IEmployeeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @GetMapping("/employees")
    public List getMethodName() {
        return this.iEmployeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Employee> gOptional = this.iEmployeeRepository.findById(id);
        if (gOptional.isPresent()) {
            Employee gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Employee entity) throws InternalServerError {

        // TODO: process POST request
        Employee employee = new Employee();
        employee.setActivated(entity.getActivated());
        employee.setAddress(entity.getAddress());
        employee.setBirthday(entity.getBirthday());
        employee.setCity(entity.getCity());
        employee.setCountry(entity.getCountry());
        employee.setEmail(entity.getEmail());
        employee.setExtension(entity.getExtension());
        employee.setFirstName(entity.getFirstName());
        employee.setHireDate(entity.getHireDate());
        employee.setHomePhone(entity.getHomePhone());
        employee.setLastName(entity.getLastName());
        employee.setPassword(entity.getPassword());
        employee.setPhoto(entity.getPhoto());
        employee.setPostalCode(entity.getPostalCode());
        employee.setProfile(entity.getProfile());
        employee.setRegion(entity.getRegion());
        employee.setTitle(entity.getTitle());
        employee.setTitleOfCoutesy(entity.getTitleOfCoutesy());
        employee.setUserLevel(entity.getUserLevel());
        employee.setUserName(entity.getUserName());

        iEmployeeRepository.save(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Employee entity) throws InternalServerError {
        // TODO: process PUT request
        Optional<Employee> uOptional = this.iEmployeeRepository.findById(id);
        if (uOptional.isPresent()) {
            Employee employee = uOptional.get();
            employee.setActivated(entity.getActivated());
            employee.setAddress(entity.getAddress());
            employee.setBirthday(entity.getBirthday());
            employee.setCity(entity.getCity());
            employee.setCountry(entity.getCountry());
            employee.setEmail(entity.getEmail());
            employee.setExtension(entity.getExtension());
            employee.setFirstName(entity.getFirstName());
            employee.setHireDate(entity.getHireDate());
            employee.setHomePhone(entity.getHomePhone());
            employee.setLastName(entity.getLastName());
            employee.setPassword(entity.getPassword());
            employee.setPhoto(entity.getPhoto());
            employee.setPostalCode(entity.getPostalCode());
            employee.setProfile(entity.getProfile());
            employee.setRegion(entity.getRegion());
            employee.setTitle(entity.getTitle());
            employee.setTitleOfCoutesy(entity.getTitleOfCoutesy());
            employee.setUserLevel(entity.getUserLevel());
            employee.setUserName(entity.getUserName());

            iEmployeeRepository.save(employee);

            return new ResponseEntity<>(employee, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Employee> dOptional = this.iEmployeeRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iEmployeeRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
