package com.college.sportik.feature.category.service;

import com.college.sportik.feature.category.dto.CategoryDTOReceive;
import com.college.sportik.feature.category.dto.CategoryDTOResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    CategoryDTOResponse createCategory(CategoryDTOResponse category);
    Optional<CategoryDTOResponse> getCategory(Long id);
    List<CategoryDTOResponse> getCategories();
    CategoryDTOResponse updateCategory(Long id, CategoryDTOReceive categoryDTOReceive);
    String deleteCategory(Long id);
}

