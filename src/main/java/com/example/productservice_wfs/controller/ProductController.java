package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.ProductRequestDTO;
import com.example.productservice_wfs.dto.ProductResponseDTO;
import com.example.productservice_wfs.mapper.ProductMapper;
import com.example.productservice_wfs.models.Product;
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
    public HttpEntity<ProductResponseDTO> getProductById(@PathVariable("productId") Long productId)
            throws Exception {
        try {
            Product data = productService.getProductById(productId);
            if (Objects.isNull(data)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("class-name", "integrating APIS");

            ProductResponseDTO dto = ProductMapper.getProductResponseDTOFromProduct(data);
            return new ResponseEntity<>(dto, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public HttpEntity<List<ProductResponseDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDTO> responseList = ProductMapper.getProductDTOListFromProducts(products);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PostMapping("/")
    public String createProduct(@RequestBody ProductRequestDTO dto) {
        //HW
        return "product created.. + " + dto.getProductName();
    }


    @PatchMapping("/{productId}")
    public HttpEntity<ProductResponseDTO> patchProduct(@PathVariable("productId") Long productId,
                                                       @RequestBody ProductRequestDTO dto) throws Exception {
        try {
            Product product = productService.patchProduct(productId,
                    ProductMapper.getProductFromCreateRequestDTO(dto));

            ProductResponseDTO responseDTO = ProductMapper.getProductResponseDTOFromProduct(product);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}

/**
 * HW
 * 1. Go through http status codes
 * 2. Try to take input as headers
 * 3. Implement Update and PUT functionalities **
 * 4. Think of a way which helps us to return some response back to client
 * in case of errors.
 */