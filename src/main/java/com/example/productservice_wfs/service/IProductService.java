package com.example.productservice_wfs.service;

import com.example.productservice_wfs.models.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(Long productId);
    List<Product> getAllProducts();
    Product patchProduct(Long productId, Product dto) throws Exception;
}
