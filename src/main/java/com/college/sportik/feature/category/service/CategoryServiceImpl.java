package com.college.sportik.feature.category.service;

import com.college.sportik.feature.category.dto.CategoryDTOReceive;
import com.college.sportik.feature.category.dto.CategoryDTOResponse;
import com.college.sportik.feature.category.entity.CategoryEntity;
import com.college.sportik.feature.category.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryDTOResponse createCategory(CategoryDTOResponse category) {
        if (repository.findByCode(category.getCode()) == null) {
            repository.save(new CategoryEntity(
                            category.getId(),
                            category.getTitle(),
                            category.getCode()
                    )
            );
            return repository.findByCode(category.getCode());
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category already exists");
        }
    }

    @Override
    public Optional<CategoryDTOResponse> getCategory(Long id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).map(item ->
                    new CategoryDTOResponse(item.getId(), item.getTitle(), item.getCode())
            );
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @Override
    public List<CategoryDTOResponse> getCategories() {
        List<CategoryDTOResponse> categories = new ArrayList<>();
        repository.findAll().forEach(item ->
               categories.add(new CategoryDTOResponse(item.getId(), item.getTitle(), item.getCode()))
        );
        return categories;
    }

    @Override
    public CategoryDTOResponse updateCategory(Long id, CategoryDTOReceive categoryDTOReceive) {
        repository.updateCategory(id.intValue(), categoryDTOReceive.getTitle(), categoryDTOReceive.getCode());
        return repository.findByCode(categoryDTOReceive.getCode());
    }

    @Override
    public String deleteCategory(Long id) {
        repository.deleteById(id);
        return "Category with id " + id + " deleted";
    }
}
