package com.base64.gamesback.category.service;

import com.base64.gamesback.category.dto.SaveCategoryDto;
import com.base64.gamesback.category.entity.Category;

import java.util.List;
import java.util.UUID;


public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(UUID uuid);

    void saveCategory(SaveCategoryDto SaveCategoryDto);

    void deleteCategory(UUID uuid);
}
