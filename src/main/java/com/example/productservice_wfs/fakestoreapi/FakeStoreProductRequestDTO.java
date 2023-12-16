package com.example.productservice_wfs.fakestoreapi;

import com.example.productservice_wfs.models.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FakeStoreProductRequestDTO {
    String title;
    Double price;
    String description;
    String image;
    Category category;
}
