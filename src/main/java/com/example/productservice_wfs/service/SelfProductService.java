package com.example.productservice_wfs.service;

import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is in house product service, this will interact with your DB.
 */
//@Component("selfProductService")
@Service
public class SelfProductService implements IProductService {
    private ProductRepository repo;

    @Autowired
    public SelfProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product getProductById(Long productId) {
        // authorization code here.
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

    /**
     * bad func added by intern.
     *
     * @param id
     * @param dto
     * @return
     */
    public Product createOrGet(Long id, Product dto) {
        Optional<Product> p = repo.findById(id); // ALREADY ADDED
        if (p.isPresent()) {
            return p.get();
        }

        // new piece of code that you added.
        repo.save(dto); // JUST ADD A MOCK FUNC TO THIS.
        Optional<Product> latestProduct = repo.findById(id); //

        return latestProduct.get();
        //return new Product();
    }
}
/**
 * HOMEWORK -> 16/12/2023
 * <p>
 * 1. Implement all the functions + Save functionality as well
 * 2. CAREFUL --> Find How to Pass Implemention for
 * These type of errors `Could not autowire. There is more than one bean of 'IProductService' type.`
 */