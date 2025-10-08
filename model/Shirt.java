package com.examly.springapp.model;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Shirt {
    @Id
    int shirtId;
    int shirtSize;
    String shirtColor;
    public Shirt()
    {
        
    }
    public Shirt(int shirtId, int shirtSize, String shirtColor) {
        this.shirtId = shirtId;
        this.shirtSize = shirtSize;
        this.shirtColor = shirtColor;
    }
    public int getShirtId() {
        return shirtId;
    }
    public void setShirtId(int shirtId) {
        this.shirtId = shirtId;
    }
    public int getShirtSize() {
        return shirtSize;
    }
    public void setShirtSize(int shirtSize) {
        this.shirtSize = shirtSize;
    }
    public String getShirtColor() {
        return shirtColor;
    }
    public void setShirtColor(String shirtColor) {
        this.shirtColor = shirtColor;
    }
    
    
}
