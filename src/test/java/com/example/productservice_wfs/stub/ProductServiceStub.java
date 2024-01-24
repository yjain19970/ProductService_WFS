package com.example.productservice_wfs.stub;

import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceStub implements IProductService {

    private Map<Long, Product> productDb = new HashMap<>();

    @Override
    public Product getProductById(Long productId) {
        return productDb.get(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Long, Product> entry : productDb.entrySet()) {
            products.add(entry.getValue());
        }
        return products;
    }

    @Override
    public Product patchProduct(Long productId, Product dto) throws Exception {
        productDb.put(productId, dto);
        return productDb.get(productId);
    }
}
