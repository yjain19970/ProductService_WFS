package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.ProductResponseDTO;
import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.service.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {

    @MockBean
    IProductService selfProductService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ObjectMapper objectMapper;

    @Test // AAA
    public void getProductByIdTest() throws Exception {
        Product p = new Product();
        p.setTitle("pen");
        p.setPrice(10.2);
        p.setId(1L);

        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(1L);
        dto.setPrice(10.2);
        dto.setTitle("pen");

        when(selfProductService.getProductById(1L))
                .thenReturn(p);

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(dto)));
    }
}
