package com.base64.gamesback.commerce.product.service;

import com.base64.gamesback.commerce.product.dto.ProductDto;
import com.base64.gamesback.commerce.product.dto.projection.ProductProjection;
import com.base64.gamesback.commerce.product.dto.UpdateProductDto;
import com.base64.gamesback.commerce.product.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product  getProductById(UUID uuid);

    List<ProductProjection> getAllProduct();

    List<ProductDto> getAllProductDto();

    void updateProduct(UpdateProductDto updateProductDto, UUID uuid);

    void createProduct(ProductDto productDto);

    void deleteProduct(UUID uuid);
}
