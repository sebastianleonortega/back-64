package com.base64.gamesback.product.service.impl;

import com.base64.gamesback.category.entity.Category;
import com.base64.gamesback.category.service.CategoryService;
import com.base64.gamesback.common.exception_handler.ResourceNotFoundException;
import com.base64.gamesback.product.dto.ProductDto;
import com.base64.gamesback.product.dto.UpdateProductDto;
import com.base64.gamesback.product.entity.Product;
import com.base64.gamesback.product.repository.ProductRepository;
import com.base64.gamesback.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Product getProductById(UUID uuid) {
        return productRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(UpdateProductDto request, UUID uuid) {
        Product product = productRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));

        product.update(
                request.getProductName(),
                request.getProductDescription(),
                request.getProductQualification(),
                request.getProductYear(),
                request.getProductImage()
        );
        productRepository.save(product);
    }


    @Override
    public void createProduct(ProductDto request) {
        Product product = Product.create(
                request.getProductName(),
                request.getProductDescription(),
                request.getProductQualification(),
                request.getProductYear(),
                request.getProductImage()
        );
        Category category = categoryService.getCategoryById(request.getCategoryId());
        product.addCategory(category);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID uuid) {
        Product product = productRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));
        productRepository.delete(product);
    }
}
