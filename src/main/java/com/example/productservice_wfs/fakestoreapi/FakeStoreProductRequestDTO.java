package com.example.productservice_wfs.fakestoreapi;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FakeStoreProductRequestDTO {
    String title;
    Double price;
    String description;
    String image;
    String category;
}
