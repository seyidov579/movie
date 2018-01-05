package com.seyidov.movie.service;

import com.seyidov.movie.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    Category create(Category category);
    Category edit(Category category);
    void deleteById(Long id);
}
