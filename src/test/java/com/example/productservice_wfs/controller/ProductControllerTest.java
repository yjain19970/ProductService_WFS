package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.ProductResponseDTO;
import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.service.SelfProductService;
import com.example.productservice_wfs.stub.ProductServiceStub;
import com.example.productservice_wfs.validator.CreateProductValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @MockBean
    SelfProductService selfProductService;

    @BeforeAll
    public static void setup() {
        System.out.println("-----BEFORE IS EXECUTED ------ ");

    }

    @AfterAll
    public static void tearDown() {
        System.out.println("-----AFTER IS EXECUTED ------ ");
    }


    @Test // AAA
    public void getProductByIdTest() throws Exception {
        ProductController pc = new ProductController(selfProductService);
        Product p = fetchProduct();

        when(selfProductService.getProductById(1L)).thenReturn(p);
        HttpEntity<ProductResponseDTO> dto = pc.getProductById(1L);

        verify(selfProductService, times(1)).getProductById(1L);

        //assert
        assertNotNull(dto);
        assertEquals("pen", dto.getBody().getTitle());
    }

    private Product fetchProduct() {
        Product p = new Product();
        p.setDescription("description");
        p.setTitle("pen");
        p.setPrice(10.2);
        p.setImageURL("image-url");
        p.setId(1L);
        return p;
    }

    @Test // AAA
    public void getAllProductsTest() throws Exception {
        ProductController pc = new ProductController(selfProductService);
        Product p = fetchProduct();

        List<Product> list = new ArrayList<>();
        list.add(p);

        when(selfProductService.getAllProducts()).thenReturn(list);

        HttpEntity<ProductResponseDTO> dto = pc.getProductById(1L);

        //assert
        assertNotNull(dto);
        assertEquals("pen", dto.getBody().getTitle());
    }

    @Test // AAA
    public void getAllProductsTestThrowsException() throws Exception {
        ProductController pc = new ProductController(selfProductService);

        when(selfProductService.getProductById(any(Long.class)))
                .thenThrow(new RuntimeException("something went wrong.."));

        assertThrows(RuntimeException.class, () -> pc.getProductById(any(Long.class)));

    }

    @Test // AAA
    public void getProductByIdTestUsingStub() throws Exception {
        ProductServiceStub productServiceStub = new ProductServiceStub();
        ProductController pc = new ProductController(productServiceStub);

        HttpEntity<ProductResponseDTO> dto = pc.getProductById(1L);

        //assert
        assertNotNull(dto);
    }

    @Test // AAA
    public void testForAllFunc() throws Exception {

        /**
         * 1. save
         * 2. fetch
         * 3. update
         */
    }


}
