package com.devcamp.project_real_estate_exchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String user;

    private String endpoint;

    private String publickey;

    private String authenticationtoken;

    private String contentencoding;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getAuthenticationtoken() {
        return authenticationtoken;
    }

    public void setAuthenticationtoken(String authenticationtoken) {
        this.authenticationtoken = authenticationtoken;
    }

    public String getContentencoding() {
        return contentencoding;
    }

    public void setContentencoding(String contentencoding) {
        this.contentencoding = contentencoding;
    }
}
