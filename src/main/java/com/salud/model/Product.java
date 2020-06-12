package com.salud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {

    private long productID;
    private int categoryID;
    private String productName;
    private String productDescription;
    private String supplier;
    private float unitPrice;
    private String productSize;
    private String color;
    private String productURLPicture;
    private boolean discountAvailable;

 
    public Product() {
  
    }
 
    public Product(int categoryID, String productName, String productDescription, String supplier, float unitPrice, String productSize, String color, String productURLPicture, boolean discountAvailable) {
         this.categoryID = categoryID;
         this.productName = productName;
         this.productDescription = productDescription;
         this.supplier = supplier;
         this.unitPrice = unitPrice;
         this.productSize = productSize;
         this.color = color;
         this.productURLPicture = productURLPicture;
         this.discountAvailable = discountAvailable;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getProductID() {
        return productID;
    }
    public void setProductID(long productID) {
        this.productID = productID;
    }
    
    @Column(name = "categoryid", nullable = false)
    public int getCategoryID() {
        return categoryID;
    }
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
 
    @Column(name = "productname", nullable = false)
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    @Column(name = "productdescription", nullable = false)
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
 
    @Column(name = "supplier", nullable = false)
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    @Column(name = "unitprice", nullable = false)
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    @Column(name = "productsize", nullable = false)
    public String getProductSize() {
        return productSize;
    }
    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }
    
    @Column(name = "color", nullable = false)
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    @Column(name = "producturlpicture", nullable = false)
    public String getProductURLPicture() {
        return productURLPicture;
    }
    public void setProductURLPicture(String productURLPicture) {
        this.productURLPicture = productURLPicture;
    }
    
    @Column(name = "discountavailable", nullable = false)
    public boolean getDiscountAvailable() {
        return discountAvailable;
    }
    public void setDiscountAvailable(boolean discountAvailable) {
        this.discountAvailable = discountAvailable;
    }

    @Override
    public String toString() {
        return "Car [productID=" + productID + ", categoryID=" + categoryID + ", productName=" + productName + ", productDescription=" + productDescription
        		+ ", supplier=" + supplier + ", unitPrice=" + unitPrice + ", productSize=" + productSize + ", color=" + color + ", productURLPicture=" + productURLPicture 
        		+ ", discountAvailabler=" + discountAvailable  + "]";  
    }
 
}