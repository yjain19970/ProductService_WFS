package com.example.productservice_wfs.service;

import com.example.productservice_wfs.fakestoreapi.FakeStoreProductRequestDTO;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import com.example.productservice_wfs.mapper.ProductMapper;
import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.utility.HttpUtil;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService implements IProductService {

    RestTemplateBuilder restTemplate;


    public FakeStoreProductService(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long productId) {
        FakeStoreProductResponse dto = restTemplate.build().
                getForEntity("https://fakestoreapi.com/products/{id}",
                        FakeStoreProductResponse.class, productId)
                .getBody();
        return ProductMapper.getProductFromFakeStoreProduct(dto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductResponse[] dto = restTemplate.build().
                getForEntity("https://fakestoreapi.com/products",
                        FakeStoreProductResponse[].class).getBody();

        return ProductMapper.getProductListFromFakeStoreList(dto);

        /**
         * Requirement:
         * List<Product> products =  fakeStoreClient.getAll();
         */
    }

    @Override
    public Product patchProduct(Long productId, Product product) throws Exception {

        /**
         * Requirement:
         * Product product =  fakeStoreClient.patchProduct(product,productId);
         */

        Product existingProduct = getProductById(productId);
        if (Objects.isNull(existingProduct)) {
            throw new Exception("Product does not exist");
        }

        FakeStoreProductRequestDTO requestDTO = new FakeStoreProductRequestDTO();
        requestDTO.setCategory(product.getCategory());
        requestDTO.setPrice(product.getPrice());
        requestDTO.setImage(product.getImageURL());
        requestDTO.setTitle(product.getProductName());

        ResponseEntity<FakeStoreProductResponse> response = HttpUtil.requestForEntity(restTemplate,
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                requestDTO, FakeStoreProductResponse.class, productId);

        return ProductMapper.getProductFromFakeStoreProduct(response.getBody());
    }
    /**
     * To be done over the weekend -->
     *
     * 1. Implement all other APIs from FakeStore
     * 2. Implement FakeStoreClient
     */
}
