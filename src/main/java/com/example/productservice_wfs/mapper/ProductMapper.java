package com.example.productservice_wfs.mapper;

import com.example.productservice_wfs.dto.ProductRequestDTO;
import com.example.productservice_wfs.dto.ProductResponseDTO;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import com.example.productservice_wfs.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static Product getProductFromFakeStoreProduct(FakeStoreProductResponse dto) {
        // ToDo: complete this.
        return new Product();
    }

    public static List<Product> getProductListFromFakeStoreList(FakeStoreProductResponse[] dtoList) {
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductResponse dto : dtoList) {
            products.add(getProductFromFakeStoreProduct(dto));
        }

        return products;
    }

    public static Product getProductFromCreateRequestDTO(ProductRequestDTO dto) {
        return new Product();
    }

    public static ProductResponseDTO getProductResponseDTOFromProduct(Product product) {
        return new ProductResponseDTO();
    }

    public static List<ProductResponseDTO> getProductDTOListFromProducts(List<Product> products) {
        List<ProductResponseDTO> responseDTOS = new ArrayList<>();
        for (Product p : products) {
            responseDTOS.add(getProductResponseDTOFromProduct(p));
        }

        return responseDTOS;
    }
}
