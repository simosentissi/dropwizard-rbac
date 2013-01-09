package com.acme.rbac.api;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @NotEmpty
    @JsonProperty
    private int id;

    @NotEmpty
    @JsonProperty
    private String username;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String familyName;

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    public User(String username, String firstName, String familyName,
            String email) {
        this.username = username;
        this.firstName = firstName;
        this.familyName = familyName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
