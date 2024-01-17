package com.example.productservice_wfs.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProductResponseDTO {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String productName;
}
