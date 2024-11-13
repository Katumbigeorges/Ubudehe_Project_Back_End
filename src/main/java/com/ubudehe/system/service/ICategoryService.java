package com.ubudehe.system.service;

import com.ubudehe.system.model.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);

    List<Category> getCategories();

    Category updateCategory(Category category, Long id);

    Category getCategoryById(Long id);

    void deleteCategory(Long id);
}
