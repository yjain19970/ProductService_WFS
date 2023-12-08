package com.example.productservice_wfs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreateProductRequestDTO {
    private String productName;
    private String category;
    private String imageURL;
    private Double price;
}
