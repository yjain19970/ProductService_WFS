package com.example.productservice_wfs.repository;

import com.example.productservice_wfs.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductId(Long id);
    List<Product> findAll();
    Product save(Product product);

}
