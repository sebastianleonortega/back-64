package com.base64.gamesback.commerce.category.service.impl;

import com.base64.gamesback.commerce.category.dto.CategoryDto;
import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.category.repository.CategoryRepository;
import com.base64.gamesback.commerce.category.service.CategoryService;
import com.base64.gamesback.common.exception.AlreadyExistException;
import com.base64.gamesback.common.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(UUID uuid) {
       return categoryRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe la categoria"));
    }

    @Override
    public CategoryDto findCategoryById(UUID uuid) {
        return categoryRepository
                .findById(uuid)
                .map(category -> new CategoryDto(
                        category.getName())
                ).orElseThrow(() -> new ResourceNotFoundException("No existe la ctegoria"));
    }

    @Override
    public void saveCategory(CategoryDto request) {
        if(categoryRepository.existsCategoryByNameIgnoreCase(request.getName())) {
            throw new AlreadyExistException("Ya existe una categoria con este nombre");
        }
        Category category = Category.create(
                request.getName()
        );
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryDto request, UUID uuid) {
        if (categoryRepository.existsCategoryByNameIgnoreCaseAndCategoryIdNot(request.getName(), uuid)) {
            throw new AlreadyExistException("Ya existe una categoria con este nombre");
        }
        Category category = categoryRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe la categoria"));
        category.update(
                request.getName()
        );
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID uuid) {
      Category category = categoryRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe la categoria que desea eliminar"));
          categoryRepository.delete(category);
    }
}
