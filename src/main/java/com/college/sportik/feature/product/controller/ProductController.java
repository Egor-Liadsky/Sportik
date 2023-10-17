package com.college.sportik.feature.product.controller;

import com.college.sportik.feature.product.dto.ProductDTOResponse;
import com.college.sportik.feature.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    Optional<ProductDTOResponse> getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    ProductDTOResponse createProduct(@RequestBody ProductDTOResponse productDTOResponse) {
        return productService.createProduct(productDTOResponse);
    }
}
