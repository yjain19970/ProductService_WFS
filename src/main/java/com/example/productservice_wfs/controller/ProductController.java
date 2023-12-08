package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.CreateProductRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/")
    public String getAllProducts(){
        return "all products...";
    }

    @PostMapping("/")
    public String createProduct(@RequestBody CreateProductRequestDTO dto){

        return "product created.. + "+ dto.getProductName();
    }

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable("productId") Integer productId){
        return "user is---"+productId;
    }
}
