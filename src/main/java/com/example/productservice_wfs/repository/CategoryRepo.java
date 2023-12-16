package com.example.productservice_wfs.repository;

import com.example.productservice_wfs.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
