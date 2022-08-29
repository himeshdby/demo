package com.example.demo.Data;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "customerinfo")
public class CustomerInfo {

    @javax.persistence.Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String lastname;
    String pan;
    Long phone;
    Date dob;
    String address;
    String occupation;
    String monthlyIncome;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

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

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public CustomerInfo(Integer id, String name, String lastName, String pan, Long phone, Date dob,String address, String occupation,String monthlyIncome) {
        this.id = id;
        this.name = name;
        this.lastname = lastName;
        this.pan = pan;
        this.phone = phone;
        this.dob = dob;
        this.address = address;
        this.occupation= occupation;
        this.monthlyIncome = monthlyIncome;
    }

    public CustomerInfo() {
    }
}
