/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Watch implements Serializable{
    private int watchID;
    private String watchName;
    private String brand;
    private BigDecimal price;
    private String description;
    private String imageURL;

    // Getters and setters

    public Watch() {
    }

    public Watch(int watchID, String watchName, String brand, BigDecimal price, String description, String imageURL) {
        this.watchID = watchID;
        this.watchName = watchName;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
    }
    

    public int getWatchID() {
        return watchID;
    }

    public void setWatchID(int watchID) {
        this.watchID = watchID;
    }

    public String getWatchName() {
        return watchName;
    }

    public void setWatchName(String watchName) {
        this.watchName = watchName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Watch{" + "watchID=" + watchID + ", watchName=" + watchName + ", brand=" + brand + ", price=" + price + ", description=" + description + ", imageURL=" + imageURL + '}';
    }
    
}

