package com.example.productservice_wfs.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity // product
public class Product extends BaseModel {
    private String title;
    private Double price;
    private String description;
    private String productName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category category;

    private String imageURL;

}
/**
 * PRODUCT<>CTEGORY
 * 1 ------ 1
 * M ------ 1
 *
 *  ---> M:1
 *
 *
 *  CATEGORY<>PRODUCT ---> 1:M
 */

/**
 * HW: Try to find how you can give own table names.
 */
