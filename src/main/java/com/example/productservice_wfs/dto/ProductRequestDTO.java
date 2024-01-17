package com.example.productservice_wfs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductRequestDTO {
    public String productName;
    public String category;
    public String imageURL;
    public Double price;
}
