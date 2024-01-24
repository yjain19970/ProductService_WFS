package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.ProductRequestDTO;
import com.example.productservice_wfs.dto.ProductResponseDTO;
import com.example.productservice_wfs.mapper.ProductMapper;
import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.security.TokenValidatorService;
import com.example.productservice_wfs.security.dto.JwtDTO;
import com.example.productservice_wfs.service.IProductService;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;
    private TokenValidatorService tokenValidatorService;

    public ProductController(IProductService productService,
                             TokenValidatorService tokenValidatorService) {
        this.productService = productService;
        this.tokenValidatorService = tokenValidatorService;
    }

    @GetMapping("/{productId}")
    public HttpEntity<ProductResponseDTO> getProductById(@PathVariable("productId") Long productId,
                                                         @Nullable @RequestHeader(HttpHeaders.AUTHORIZATION)
                                                                 String token)
            throws Exception {
        try {

            if (!validateToken(token)) {
                return new ResponseEntity<>(HttpStatus.TEMPORARY_REDIRECT);
            }

            Product data = productService.getProductById(productId);
            if (Objects.isNull(data)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("class-name", "integrating APIS");

            ProductResponseDTO dto = getProductResponseDTOFromProduct(data);
            return new ResponseEntity<>(dto, headers, HttpStatus.OK);
        } catch (ArithmeticException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            //throw e;
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateToken(String token) {
        if (Objects.isNull(token)) {
            return false;
        }
        /**
         * add your custom logic here
         */
        Optional<JwtDTO> jwtDTO = tokenValidatorService.validateToken(token);
        if (jwtDTO.isEmpty()) {
            return false;
        }

        /**
         * proceed with any specific validations if you want to do.
         */

        return true;
    }

    public ProductResponseDTO getProductResponseDTOFromProduct(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setId(product.getId());
        return dto;
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