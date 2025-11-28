package com.base64.gamesback.commerce.product.service.impl;

import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.category.service.CategoryService;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.commerce.service.CommerceService;
import com.base64.gamesback.commerce.product.dto.ProductDto;
import com.base64.gamesback.commerce.product.dto.UpdateProductDto;
import com.base64.gamesback.commerce.product.entity.Product;
import com.base64.gamesback.commerce.product.repository.ProductRepository;
import com.base64.gamesback.commerce.product.service.ProductService;
import com.base64.gamesback.commerce.tax.entity.Tax;
import com.base64.gamesback.commerce.tax.service.TaxService;
import com.base64.gamesback.common.exception.AlreadyExistException;
import com.base64.gamesback.common.exception.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CommerceService commerceService;
    private final CategoryService categoryService;
    private final TaxService taxService;

    public ProductServiceImpl(ProductRepository productRepository, CommerceService commerceService, CategoryService categoryService, TaxService taxService) {
        this.productRepository = productRepository;
        this.commerceService = commerceService;
        this.categoryService = categoryService;
        this.taxService = taxService;
    }

    @Override
    public void updateProduct(UpdateProductDto request, UUID uuid) {
        if (productRepository.existsProductByNameIgnoreCaseAndProductIdNot(request.getName(), uuid)) {
            throw new AlreadyExistException("Ya existe un producto con el nombre: " + request.getName());
        }
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
        if (productRepository.existsProductByNameIgnoreCase(request.getName())){
            throw new AlreadyExistException("Ya existe un producto con el nombre: " + request.getName());
        }
        Product product = Product.create(
                request.getName(),
                request.getDescription(),
                request.getCode(),
                request.getPrice(),
                request.getStock(),
                request.getImage()
        );
        Category category = categoryService.getCategoryById(request.getCategoryId());
        Commerce commerce = commerceService.getCommerceById(request.getCommerceId());
        List<Tax> taxes = taxService.getTaxesById(request.getTaxes());
        product.addCategory(category);
        product.addCommerce(commerce);
        product.addTax(taxes);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID uuid) {
        Product product = productRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));
        productRepository.delete(product);
    }
}
