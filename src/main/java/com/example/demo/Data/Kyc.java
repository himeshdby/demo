package com.example.demo.Data;

import javax.persistence.*;
import java.sql.Date;


@Table(name = "kycdetails")
public class Kyc {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String lastname;
    //String pan;
    Long phone;
    String uniqueId;

   /* public Kyc(Integer id, String name, String lastname, String pan, Long phone, String uniqueId) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.pan = pan;
        this.phone = phone;
        this.uniqueId = uniqueId;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /*public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }*/

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getUniqueId() {
        return  uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
