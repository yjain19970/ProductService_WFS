package com.example.productservice_wfs.repository;

import com.example.productservice_wfs.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category save(Category category);

    Optional<Category> findById(Long id);
}
