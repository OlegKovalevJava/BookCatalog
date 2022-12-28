package com.project.book_catalog.service;

import com.project.book_catalog.entity.Product;
import com.project.book_catalog.entity.SearchQuery;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testWhenAddNewProductShouldSaved() {
        Product product = new Product();
        product.setCategory("Books");
        product.setDescription("How to program in 10 minutes");
        product.setName("Best book ever");
        product.setQuantity(10);
        product.setPrice(new BigDecimal("200"));

        productService.addProduct(product);

        List<Product> products = productService.findProductByName(new SearchQuery(1L, "Best book ever"));
        Assert.assertFalse(products.isEmpty());
    }
}
