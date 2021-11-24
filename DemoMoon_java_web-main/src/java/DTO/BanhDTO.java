/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class BanhDTO implements Serializable{
    int BanhID;
    String BanhName;
    String image;
    float price;
    int quantity;
    String description;
    String CurrentDate;
    boolean Status;
    int CategoryID;

    public BanhDTO() {
    }

    public BanhDTO(int BanhID, String BanhName, String image, float price, int quantity, String author, String CurrentDate, boolean Status, int CategoryID) {
        this.BanhID = BanhID;
        this.BanhName = BanhName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = author;
        this.CurrentDate = CurrentDate;
        this.Status = Status;
        this.CategoryID = CategoryID;
    }

    public int getBanhID() {
        return BanhID;
    }

    public void setBanhID(int BanhID) {
        this.BanhID = BanhID;
    }

    public String getBanhName() {
        return BanhName;
    }

    public void setBanhName(String BanhName) {
        this.BanhName = BanhName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(String CurrentDate) {
        this.CurrentDate = CurrentDate;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setAuthor(String author) {
        this.description = author;
    }

    @Override
    
    public String toString() {
        return "BanhDTO{" + "BanhID=" + BanhID + ", BanhName=" + BanhName + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", description=" + description + ", CurrentDate=" + CurrentDate + ", Status=" + Status + ", CategoryID=" + CategoryID + '}';
    }

    
    
    
    
}
