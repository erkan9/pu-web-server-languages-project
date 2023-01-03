package org.erkamber.dtos;

import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class ProductDto {

    private int productID;

    @Size(max = 50, message = "Product Name has to be less than 50 characters")
    private String productName;

    @Size(max = 2000, message = "Product Name has to be less than 50 characters")
    private String productDescription = null;

    @Size(max = 2000, message = "Product Image URI has to be less than 50 characters")
    private String imageUri = null;

    @Positive
    private double purchasePrice;

    @Positive
    private double sellPrice;

    @PositiveOrZero
    private int productQuantity;

    private String productCategory;

    private String productCode;

    public ProductDto() {
    }

    public ProductDto(String productName, String productDescription, String imageUri, double purchasePrice, double sellPrice,
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

    public ProductDto(int productID, String productName, String productDescription, String imageUri, double purchasePrice,
                      double sellPrice, int productQuantity, String productCategory, String productCode) {

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