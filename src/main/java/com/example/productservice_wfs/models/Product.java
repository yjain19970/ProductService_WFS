package com.example.productservice_wfs.models;


import lombok.Data;

@Data
public class Product extends BaseModel{
    private String productName;
    private String category;
    private String imageURL;
    private Double price;
}
