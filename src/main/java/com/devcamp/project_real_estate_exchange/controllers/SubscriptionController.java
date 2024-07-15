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
import com.devcamp.project_real_estate_exchange.entity.Subscription;
import com.devcamp.project_real_estate_exchange.res.ISubscriptionRepository;

@RestController
@CrossOrigin
public class SubscriptionController {
    @Autowired
    ISubscriptionRepository iSubscriptionRepository;

    @GetMapping("/subscriptions")
    public List getMethodName() {
        return this.iSubscriptionRepository.findAll();
    }

    @GetMapping("/subscriptions/{id}")
    public ResponseEntity<Object> getByIdMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Subscription> gOptional = this.iSubscriptionRepository.findById(id);
        if (gOptional.isPresent()) {
            Subscription gId = gOptional.get();

            return new ResponseEntity<>(gId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Subscription entity) {

        // TODO: process POST request
        Subscription subscription = new Subscription();
        subscription.setAuthenticationtoken(entity.getAuthenticationtoken());
        subscription.setContentencoding(entity.getContentencoding());
        subscription.setEndpoint(entity.getEndpoint());
        subscription.setPublickey(entity.getPublickey());
        subscription.setUser(entity.getUser());

        iSubscriptionRepository.save(subscription);

        return new ResponseEntity<>(subscription, HttpStatus.CREATED);
    }

    @PutMapping("/subscriptions/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable int id, @RequestBody Subscription entity) {
        // TODO: process PUT request
        Optional<Subscription> uOptional = this.iSubscriptionRepository.findById(id);
        if (uOptional.isPresent()) {
            Subscription subscription = uOptional.get();
            subscription.setAuthenticationtoken(entity.getAuthenticationtoken());
            subscription.setContentencoding(entity.getContentencoding());
            subscription.setEndpoint(entity.getEndpoint());
            subscription.setPublickey(entity.getPublickey());
            subscription.setUser(entity.getUser());

            iSubscriptionRepository.save(subscription);

            return new ResponseEntity<>(subscription, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/subscriptions/{id}")
    public ResponseEntity<Object> deleteMethodName(@PathVariable int id) throws InternalServerError {
        Optional<Subscription> dOptional = this.iSubscriptionRepository.findById(id);
        if (dOptional.isPresent()) {
            this.iSubscriptionRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
