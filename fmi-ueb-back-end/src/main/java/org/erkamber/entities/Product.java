package org.erkamber.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, updatable = false, insertable = false, nullable = false)
    private int productID;

    @Column(name = "name", length = 50, unique = false, updatable = true, insertable = true, nullable = true)
    private String productName;

    @Column(name = "description", length = 2000, unique = false, updatable = true, insertable = true, nullable = true)
    private String productDescription = null;

    @Column(name = "image_url", length = 2000, unique = false, updatable = true, insertable = true, nullable = true)
    private String imageUri = null;

    @Column(name = "purchase_price", unique = false, updatable = true, insertable = true, nullable = false)
    private double purchasePrice;

    @Column(name = "sell_price", unique = false, updatable = true, insertable = true, nullable = false)
    private double sellPrice;

    @Column(name = "quantity", unique = false, updatable = true, insertable = true, nullable = false)
    private int productQuantity;

    @Column(name = "category", unique = false, updatable = true, insertable = true, nullable = false)
    private String productCategory;

    @Column(name = "code", unique = true, updatable = true, insertable = true, nullable = false)
    private String productCode;

    public Product() {
    }

    public Product(String productName, String productDescription, String imageUri, double purchasePrice, double sellPrice,
                   int productQuantity, String productCategory, String productCode) {

        this.productName = productName;
        this.productDescription = productDescription;
        this.imageUri = imageUri;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
        this.productCode = productCode;
    }

    public Product(int productID, String productName, String productDescription, String imageUri, double purchasePrice, double sellPrice,
                   int productQuantity, String productCategory, String productCode) {

        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.imageUri = imageUri;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
        this.productCode = productCode;
    }
}