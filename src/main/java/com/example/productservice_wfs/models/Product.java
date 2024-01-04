package com.example.productservice_wfs.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity // product
public class Product extends BaseModel {
    private String title;
    private Double price;
    private String description;
    private String productName;

    @ManyToOne(cascade = CascadeType.ALL) // NextClass
    private Category category;

    private String imageURL;

}

/**
 * HW: Try to find how you can give own table names.
 */
