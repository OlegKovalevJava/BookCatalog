package com.project.book_catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchQuery {

    private Long id;
    private String name;
}
