package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.CreateProductRequestDTO;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import com.example.productservice_wfs.service.IProductService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public HttpEntity<FakeStoreProductResponse> getProductById(@PathVariable("productId") Long productId) throws Exception {
        FakeStoreProductResponse data =  productService.getProductById(productId);

        try{
            if(Objects.isNull(data)){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("class-name", "integrating APIS");
            return new ResponseEntity<>(data,headers, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public HttpEntity<List<FakeStoreProductResponse>> getAllProducts(){
        List<FakeStoreProductResponse> responseList =  productService.getAllProducts();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PostMapping("/")
    public String createProduct(@RequestBody CreateProductRequestDTO dto){
        return "product created.. + "+ dto.getProductName();
    }
}

/**
 * HW
 * 1. Go through http status codes
 * 2. Try to take input as headers
 * 3. Implement Update and PUT functionalities **
 * 4. Think of a way which helps us to return some response back to client
 *      in case of errors.
 */