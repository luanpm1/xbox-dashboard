package com.devcamp.project_real_estate_exchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "address_maps")
public class AddressMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private double _lat;

    
    @Column(nullable = false)
    private double _lng;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public double get_lat() {
        return _lat;
    }


    public void set_lat(double _lat) {
        this._lat = _lat;
    }


    public double get_lng() {
        return _lng;
    }


    public void set_lng(double _lng) {
        this._lng = _lng;
    }


    

    

    


    
    
}
