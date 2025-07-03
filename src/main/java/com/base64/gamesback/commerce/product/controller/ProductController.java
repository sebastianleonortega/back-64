package com.base64.gamesback.commerce.product.controller;


import com.base64.gamesback.commerce.product.dto.ProductDto;
import com.base64.gamesback.commerce.product.dto.projection.ProductProjection;
import com.base64.gamesback.commerce.product.dto.UpdateProductDto;
import com.base64.gamesback.commerce.product.entity.Product;
import com.base64.gamesback.commerce.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService  productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{uuid}")
    @Operation(description = "get by id")
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<Product> getProductById(@Valid @PathVariable UUID uuid){
        return new ResponseEntity<>(productService.getProductById(uuid), HttpStatus.OK) ;
    }

    @GetMapping("/")
    @Operation(description = "get all")
    @ApiResponse(responseCode = "200", description = "success")
    public  ResponseEntity<List<ProductProjection>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(description = "create product")
    @ApiResponse(responseCode = "201", description = "created")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody ProductDto productDto){
        productService.createProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    @Operation(description = "update product")
    @ApiResponse(responseCode = "204", description = "no content")
    public  ResponseEntity<HttpStatus> updatePerson(@Valid @PathVariable UUID uuid, @Valid @RequestBody UpdateProductDto updateProductDto){
        productService.updateProduct(updateProductDto, uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{uuid}")
    @Operation(description = "delete product")
    @ApiResponse(responseCode = "404", description = "no content")
    public ResponseEntity<HttpStatus> deleteProduct(@Valid @PathVariable UUID uuid){
        productService.deleteProduct(uuid);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
