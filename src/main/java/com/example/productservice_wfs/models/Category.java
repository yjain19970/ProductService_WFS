package com.example.productservice_wfs.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity // category
public class Category extends BaseModel {
    private String name;

    private String description;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;
}
