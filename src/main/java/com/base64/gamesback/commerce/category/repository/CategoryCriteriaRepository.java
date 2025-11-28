package com.base64.gamesback.commerce.category.repository;
import com.base64.gamesback.commerce.category.dto.ListCategoryDto;
import java.util.List;

public interface CategoryCriteriaRepository {

    List<ListCategoryDto> getAllCategories();
}
