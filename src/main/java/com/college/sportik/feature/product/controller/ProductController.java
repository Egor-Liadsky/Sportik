package com.college.sportik.feature.product.controller;

import com.college.sportik.feature.product.dto.ProductDTOReceive;
import com.college.sportik.feature.product.dto.ProductDTOResponse;
import com.college.sportik.feature.product.entity.ProductEntity;
import com.college.sportik.feature.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    ProductDTOResponse createProduct(@RequestBody ProductDTOResponse productDTOResponse) {
        return productService.createProduct(productDTOResponse);
    }

    @GetMapping("/{id}")
    ProductDTOReceive getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    List<ProductDTOReceive> getProducts() {
        return productService.getProducts();
    }
}
