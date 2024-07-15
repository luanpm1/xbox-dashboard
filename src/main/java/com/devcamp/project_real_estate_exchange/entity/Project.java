package com.devcamp.project_real_estate_exchange.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.poi.hpsf.Decimal;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String slogan;

    private String description;

    private BigDecimal acreage;

    private BigDecimal constructArea;

    private BigDecimal numBlock;

    private String numFloors;

    private String numApartment;

    private String apartmentArea;

    private String investor;

    private String constructionContractor;

    private String designUnit;

    private String utilities;

    private String regionLink;

    private String photo;

    private String _lat;

    private String _lng;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
    }

    public BigDecimal getConstructArea() {
        return constructArea;
    }

    public void setConstructArea(BigDecimal constructArea) {
        this.constructArea = constructArea;
    }

    public BigDecimal getNumBlock() {
        return numBlock;
    }

    public void setNumBlock(BigDecimal numBlock) {
        this.numBlock = numBlock;
    }

    public String getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(String numFloors) {
        this.numFloors = numFloors;
    }

    public String getNumApartment() {
        return numApartment;
    }

    public void setNumApartment(String numApartment) {
        this.numApartment = numApartment;
    }

    public String getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(String apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public String getConstructionContractor() {
        return constructionContractor;
    }

    public void setConstructionContractor(String constructionContractor) {
        this.constructionContractor = constructionContractor;
    }

    public String getDesignUnit() {
        return designUnit;
    }

    public void setDesignUnit(String designUnit) {
        this.designUnit = designUnit;
    }

    public String getUtilities() {
        return utilities;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }

    public String getRegionLink() {
        return regionLink;
    }

    public void setRegionLink(String regionLink) {
        this.regionLink = regionLink;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String get_lat() {
        return _lat;
    }

    public void set_lat(String _lat) {
        this._lat = _lat;
    }

    public String get_lng() {
        return _lng;
    }

    public void set_lng(String _lng) {
        this._lng = _lng;
    }
}
