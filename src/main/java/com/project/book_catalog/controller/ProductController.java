package com.project.book_catalog.controller;

import com.project.book_catalog.entity.Product;
import com.project.book_catalog.entity.SearchQuery;
import com.project.book_catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteProduct(@RequestBody Product product) {
        this.productService.deleteProduct(product);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    public List<Product> findName(@RequestBody SearchQuery searchQuery) {
        return this.productService.findProductByName(searchQuery);
    }
}
