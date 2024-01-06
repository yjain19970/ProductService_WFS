package com.example.productservice_wfs;

import com.example.productservice_wfs.models.Category;
import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.repository.CategoryRepo;
import com.example.productservice_wfs.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    void saveProductAndCategory() {
        Category c = new Category();
        c.setName("Electronics");
        c.setDescription("Electricals..");
        //categoryRepo.save(c);


        Product p = new Product();
        p.setTitle("Samsung phone");
        p.setDescription("Samsung Galaxy s23");
        p.setCategory(c);

        //productRepository.save(p);

        System.out.println("NOW PRODUCT------");
        Optional<Product> dbProduct = productRepository.findById(1L);
        System.out.println(dbProduct.get().getTitle()); // samsung phone
        System.out.println(dbProduct.get().getCategory().getDescription()); // Electricals

        System.out.println("NOW CATEGORY------");
        Optional<Category> dbCat = categoryRepo.findById(1L);
        System.out.println(dbCat.get().getProducts().size()); // 1
        System.out.println(dbCat.get().getDescription()); // Electricals..

        // LAZY vs EAGER LOADING

    }
}
