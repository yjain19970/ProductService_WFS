package com.example.productservice_wfs.service;

import com.example.productservice_wfs.dto.CreateProductRequestDTO;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductRequestDTO;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import io.micrometer.common.lang.Nullable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements IProductService {

    RestTemplateBuilder restTemplate;

    public ProductService(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public FakeStoreProductResponse getProductById(Long productId) {
        FakeStoreProductResponse dto = restTemplate.build().
                getForEntity("https://fakestoreapi.com/products/{id}",
                        FakeStoreProductResponse.class, productId)
                .getBody();

        return dto;
    }

    @Override
    public List<FakeStoreProductResponse> getAllProducts() {
        FakeStoreProductResponse[] dto =  restTemplate.build().
                getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductResponse[].class).getBody();

        return Arrays.asList(dto);
    }

    @Override
    public FakeStoreProductResponse patchProduct(Long productId, CreateProductRequestDTO dto) {
        /**
         * ToDo: Fetch the Product and verify whether if Product exists.
         * If Not -- Throw exception
         */

        FakeStoreProductRequestDTO requestDTO = new FakeStoreProductRequestDTO();
        requestDTO.setCategory(dto.getCategory());
        requestDTO.setPrice(dto.getPrice());
        requestDTO.setImage(dto.getImageURL());
        requestDTO.setTitle(dto.getProductName());

        ResponseEntity<FakeStoreProductResponse> response =  requestForEntity(HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                requestDTO,FakeStoreProductResponse.class,productId);

        return response.getBody();
    }



    // this method we have created by our OWN>
    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate t = restTemplate.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();

        RequestCallback requestCallback =t.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = t.responseEntityExtractor(responseType);
        return t.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
