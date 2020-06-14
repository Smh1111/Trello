package com.example.demo.model;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    private String username;
    private String name;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private Short verified = 1;  //?


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String  username) {
        this.username = username;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Short getVerified() {
        return verified;
    }

    public void setVerified(Short verified) {
        this.verified = verified;
    }
}
