package com.demo.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.demo.validator.annotation.UniqueEmail;
import com.demo.validator.sequence.Registration;

public class User {

    private long id;

    @NotBlank
    private String name;

    @NotEmpty
    @Email
    @UniqueEmail(groups = Registration.class)
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    @Past
    private Date dob;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

}
