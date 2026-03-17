package com.base64.gamesback.commerce.product.service;

import com.base64.gamesback.commerce.product.dto.ProductDto;
import com.base64.gamesback.commerce.product.dto.UpdateProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    void updateProduct(UpdateProductDto updateProductDto, UUID uuid);

    void createProduct(ProductDto productDto);

    void deleteProduct(UUID uuid);

    ProductDto getProductById(UUID uuid);

    List<ProductDto> getAllProduct();
}
