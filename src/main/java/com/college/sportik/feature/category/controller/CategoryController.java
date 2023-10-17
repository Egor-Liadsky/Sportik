package com.college.sportik.feature.category.controller;

import com.college.sportik.feature.category.dto.CategoryDTOReceive;
import com.college.sportik.feature.category.dto.CategoryDTOResponse;
import com.college.sportik.feature.category.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    Optional<CategoryDTOResponse> getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping
    List<CategoryDTOResponse> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    CategoryDTOResponse createCategory(@RequestBody CategoryDTOResponse categoryDTOResponse) {
        return categoryService.createCategory(categoryDTOResponse);
    }

    @PutMapping("/{id}")
    CategoryDTOResponse updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDTOReceive categoryDTOReceive) {
        return categoryService.updateCategory(id, categoryDTOReceive);
    }

    @DeleteMapping("/{id}")
    String deleteCategory(@PathVariable("id") Long id) {
        return categoryService.deleteCategory(id);
    }
}
