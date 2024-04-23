package com.base64.gamesback.category.controller;

import com.base64.gamesback.category.dto.SaveCategoryDto;
import com.base64.gamesback.category.entity.Category;
import com.base64.gamesback.category.service.CategoryService;
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

    @GetMapping("/")
    @Operation(description = "get all category" )
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK) ;
    }

    @GetMapping("/{categoryId}")
    @Operation(description = "get all category" )
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<Category> getAllCategoryById(@Valid @PathVariable UUID categoryId){
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId), HttpStatus.OK) ;
    }

    @PostMapping("/")
    @Operation(description = "save category" )
    @ApiResponse(responseCode = "201", description = "created")
    public ResponseEntity<HttpStatus> saveCategory(@Valid @RequestBody SaveCategoryDto saveCategoryDto){
        categoryService.saveCategory(saveCategoryDto);
        return new ResponseEntity<>( HttpStatus.OK) ;
    }

    @DeleteMapping("/{uuid}")
    @Operation(description = "delete category")
    @ApiResponse(responseCode = "204", description = "no content")
    public ResponseEntity<HttpStatus> deleteCategory(@Valid @PathVariable UUID uuid){
        categoryService.deleteCategory(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
