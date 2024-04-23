package com.base64.gamesback.product.service;

import com.base64.gamesback.product.dto.ProductDto;
import com.base64.gamesback.product.dto.UpdateProductDto;
import com.base64.gamesback.product.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product  getProductById(UUID uuid);

    List<Product> getAllProduct();

    void updateProduct(UpdateProductDto updateProductDto, UUID uuid);

    void createProduct(ProductDto productDto);

    void deleteProduct(UUID uuid);
}
