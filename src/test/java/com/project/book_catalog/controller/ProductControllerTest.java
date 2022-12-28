package com.project.book_catalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.book_catalog.entity.Product;
import com.project.book_catalog.entity.SearchQuery;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @Resource
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testWhenAddNewProductShouldCheckThatItWasAdded() throws Exception {
        Product product = new Product();
        product.setCategory("Books");
        product.setDescription("How to program in 10 minutes");
        product.setName("Best book ever");
        product.setQuantity(10);
        product.setPrice(new BigDecimal("200"));

        mockMvc.perform(post("/api/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andDo(print());

        SearchQuery searchQuery = new SearchQuery(1L, "Best book ever");

        mockMvc.perform(post("/api/findByName")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchQuery)))
                .andDo(print());
    }
}