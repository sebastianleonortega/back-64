package com.base64.gamesback.commerce.product.repository;

import com.base64.gamesback.commerce.product.dto.ProductDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductCriteriaRepository {

    List<ProductDto> getAllProduct();

    ProductDto getProductById(UUID uuid);
}
