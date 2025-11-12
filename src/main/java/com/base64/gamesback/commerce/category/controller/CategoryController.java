package com.base64.gamesback.commerce.category.controller;

import com.base64.gamesback.commerce.category.dto.CategoryDto;
import com.base64.gamesback.commerce.category.dto.ListCategoryDto;
import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.category.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    @Operation(description = "get all category" )
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<List<ListCategoryDto>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    @Operation(description = "get all category" )
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<CategoryDto> getAllCategoryById(@Valid @PathVariable UUID categoryId){
        return new ResponseEntity<>(categoryService.findCategoryById(categoryId), HttpStatus.OK) ;
    }

    @PostMapping("/save")
    @Operation(description = "save category" )
    @ApiResponse(responseCode = "201", description = "created")
    public ResponseEntity<HttpStatus> saveCategory(@Valid @RequestBody CategoryDto category){
        categoryService.saveCategory(category);
        return new ResponseEntity<>( HttpStatus.OK) ;
    }

    @PutMapping("/{categoryId}")
    @Operation(description = "update category")
    @ApiResponse(responseCode = "200", description = "update")
    public ResponseEntity<HttpStatus> updateCategory(@Valid @RequestBody CategoryDto category, @PathVariable UUID categoryId){
        categoryService.updateCategory(category, categoryId);
        return new ResponseEntity<>( HttpStatus.OK) ;
    }

    @DeleteMapping("/{categoryId}")
    @Operation(description = "delete category")
    @ApiResponse(responseCode = "202", description = "success")
    public ResponseEntity<HttpStatus> deleteCategory(@Valid @PathVariable UUID categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
