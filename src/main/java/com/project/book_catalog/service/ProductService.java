package com.project.book_catalog.service;

import com.project.book_catalog.entity.Product;
import com.project.book_catalog.entity.SearchQuery;
import com.project.book_catalog.exceptions.NotFoundProductException;
import com.project.book_catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        this.productRepository.delete(product);
    }

    public void editProduct(Product product) {
        this.productRepository.save(product);
    }

    public List<Product> findProductByName(SearchQuery searchQuery) {
        List<Product> products = this.productRepository.findByName(searchQuery.getName());
        if (products.isEmpty()) {
            throw new NotFoundProductException("Could not find the product");
        }
        return products;
    }
}
