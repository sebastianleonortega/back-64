package com.base64.gamesback.category.service.impl;

import com.base64.gamesback.category.dto.SaveCategoryDto;
import com.base64.gamesback.category.entity.Category;
import com.base64.gamesback.category.repository.CategoryRepository;
import com.base64.gamesback.category.service.CategoryService;
import com.base64.gamesback.common.exception_handler.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(UUID uuid) {
       return categoryRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe la categoria"));
    }

    @Override
    public void saveCategory(SaveCategoryDto request) {
        Category category = Category.create(
                request.getCategoryName().toLowerCase(Locale.ROOT)
        );
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID uuid) {
      Category category = categoryRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe la categoria que desea eliminar"));
          categoryRepository.delete(category);
    }
}
