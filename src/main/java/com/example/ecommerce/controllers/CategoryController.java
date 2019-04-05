package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> listProducts(){
        return categoryService.listAllCategories();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/createCategory")
    public Category newCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }
}