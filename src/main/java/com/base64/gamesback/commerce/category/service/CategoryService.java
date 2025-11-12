package com.base64.gamesback.commerce.category.service;

import com.base64.gamesback.commerce.category.dto.CategoryDto;
import com.base64.gamesback.commerce.category.dto.ListCategoryDto;
import com.base64.gamesback.commerce.category.entity.Category;

import java.util.List;
import java.util.UUID;


public interface CategoryService {

    List<ListCategoryDto> getAllCategories();

    Category getCategoryById(UUID uuid);

    CategoryDto findCategoryById(UUID uuid);

    void saveCategory(CategoryDto category);

    void updateCategory(CategoryDto category, UUID uuid);

    void deleteCategory(UUID uuid);
}
