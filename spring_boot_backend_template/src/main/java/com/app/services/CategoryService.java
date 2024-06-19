package com.app.services;

import java.util.List;

import com.app.entities.Category;

public interface CategoryService {
	
	List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id);

}
