package com.devcamp.project_real_estate_exchange.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.UIDefaults.ActiveValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Input lastName")
    @NotEmpty(message = "Empty lastName")
    private String lastName;
    
    @NotNull(message = "Input firstName")
    @NotEmpty(message = "Empty firstName")
    private String firstName;

    
    private String title;

    
    private String titleOfCoutesy;

    @Temporal(TemporalType.TIMESTAMP)
    
    private Date birthday;

    @Temporal(TemporalType.TIMESTAMP)
    
    private Date hireDate;

    
    private String address;

    
    private String city;

    
    private String region;

   
    private String postalCode;

   
    private String country;

    
    private String homePhone;

    
    private String extension;

    
    private String photo;

    
    private String userName;

    
    private String password;

    
    private String email;

    @Enumerated(EnumType.STRING)
    
    private ActivationStatus activated;

    
    private String profile;
    
    
    private Integer userLevel;



    

    public int getId() {
        return id;
    }





    public void setId(int id) {
        this.id = id;
    }





    public String getLastName() {
        return lastName;
    }





    public void setLastName(String lastName) {
        this.lastName = lastName;
    }





    public String getFirstName() {
        return firstName;
    }





    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }





    public String getTitle() {
        return title;
    }





    public void setTitle(String title) {
        this.title = title;
    }





    public String getTitleOfCoutesy() {
        return titleOfCoutesy;
    }





    public void setTitleOfCoutesy(String titleOfCoutesy) {
        this.titleOfCoutesy = titleOfCoutesy;
    }





    public Date getBirthday() {
        return birthday;
    }





    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }





    public Date getHireDate() {
        return hireDate;
    }





    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }





    public String getAddress() {
        return address;
    }





    public void setAddress(String address) {
        this.address = address;
    }





    public String getCity() {
        return city;
    }





    public void setCity(String city) {
        this.city = city;
    }





    public String getRegion() {
        return region;
    }





    public void setRegion(String region) {
        this.region = region;
    }





    public String getPostalCode() {
        return postalCode;
    }





    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }





    public String getCountry() {
        return country;
    }





    public void setCountry(String country) {
        this.country = country;
    }





    public String getHomePhone() {
        return homePhone;
    }





    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }





    public String getExtension() {
        return extension;
    }





    public void setExtension(String extension) {
        this.extension = extension;
    }





    public String getPhoto() {
        return photo;
    }





    public void setPhoto(String photo) {
        this.photo = photo;
    }





    public String getUserName() {
        return userName;
    }





    public void setUserName(String userName) {
        this.userName = userName;
    }





    public String getPassword() {
        return password;
    }





    public void setPassword(String password) {
        this.password = password;
    }





    public String getEmail() {
        return email;
    }





    public void setEmail(String email) {
        this.email = email;
    }





    public ActivationStatus getActivated() {
        return activated;
    }





    public void setActivated(ActivationStatus activated) {
        this.activated = activated;
    }





    public String getProfile() {
        return profile;
    }





    public void setProfile(String profile) {
        this.profile = profile;
    }





    public Integer getUserLevel() {
        return userLevel;
    }





    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }





    public enum ActivationStatus {
        Y,
        N
    }





    
    
}
