package com.base64.gamesback.commerce.product.service.impl;

import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.category.service.CategoryService;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.commerce.service.CommerceService;
import com.base64.gamesback.commerce.product.dto.ProductDto;
import com.base64.gamesback.commerce.product.dto.projection.ProductProjection;
import com.base64.gamesback.commerce.product.dto.UpdateProductDto;
import com.base64.gamesback.commerce.product.entity.Product;
import com.base64.gamesback.commerce.product.repository.ProductRepository;
import com.base64.gamesback.commerce.product.service.ProductService;
import com.base64.gamesback.common.exception_handler.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CommerceService commerceService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CommerceService commerceService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.commerceService = commerceService;
        this.categoryService = categoryService;
    }

    @Override
    public Product getProductById(UUID uuid) {
        return productRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));
    }

    @Override
    public List<ProductProjection> getAllProduct() {
        return productRepository.getAllProductDto();
    }

    @Override
    public List<ProductDto> getAllProductDto() {

        return productRepository.getProductsAll();
    }

    @Override
    public void updateProduct(UpdateProductDto request, UUID uuid) {
        Product product = productRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));

        product.update(
                request.getName(),
                request.getDescription(),
                request.getCode(),
                request.getPrice(),
                request.getStock(),
                request.getImage()
        );
        productRepository.save(product);
    }


    @Override
    public void createProduct(ProductDto request) {
        Product product = Product.create(
                request.getName(),
                request.getDescription(),
                request.getCode(),
                request.getPrice(),
                request.getStock(),
                request.getImage()
        );
        Category category = categoryService.getCategoryById(request.getCategoryId());
        Commerce commerce = commerceService.GetCommerceById(request.getCommerceId());
        product.addCategory(category);
        product.addCommerce(commerce);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID uuid) {
        Product product = productRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));
        productRepository.delete(product);
    }
}
