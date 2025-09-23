package com.example.springapp.model;
 
import javax.persistence.Entity;
import javax.persistence.Id;
 
@Entity
public class Children {
    @Id
    int babyId;
    String babyFirstName,babyLastName,fatherName,motherName,address;
    public Children() {
    }
    public Children(int babyId, String babyFirstName, String babyLastName, String fatherName, String motherName,
            String address) {
        this.babyId = babyId;
        this.babyFirstName = babyFirstName;
        this.babyLastName = babyLastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.address = address;
    }
    public int getBabyId() {
        return babyId;
    }
    public void setBabyId(int babyId) {
        this.babyId = babyId;
    }
    public String getBabyFirstName() {
        return babyFirstName;
    }
    public void setBabyFirstName(String babyFirstName) {
        this.babyFirstName = babyFirstName;
    }
    public String getBabyLastName() {
        return babyLastName;
    }
    public void setBabyLastName(String babyLastName) {
        this.babyLastName = babyLastName;
    }
    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    public String getMotherName() {
        return motherName;
    }
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
 
   
}
