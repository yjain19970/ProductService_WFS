package com.example.productservice_wfs.service;

import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is in house product service, this will interact with your DB.
 */
@Component("selfProductService")
public class SelfProductService implements IProductService {
    private ProductRepository repo;

    public SelfProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> p = repo.findById(productId);
        return p.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product patchProduct(Long productId, Product dto) throws Exception {
        return null;
    }
}
/**
 * HOMEWORK -> 16/12/2023
 *
 * 1. Implement all the functions + Save functionality as well
 * 2. CAREFUL --> Find How to Pass Implemention for
 * These type of errors `Could not autowire. There is more than one bean of 'IProductService' type.`
 */