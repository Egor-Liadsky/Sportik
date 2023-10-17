package com.college.sportik.feature.product.service;

import com.college.sportik.feature.product.dto.ProductDTOReceive;
import com.college.sportik.feature.product.dto.ProductDTOResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    ProductDTOResponse createProduct(ProductDTOResponse productDTOResponse);
    Optional<ProductDTOResponse> getProductById(Long id);
    List<ProductDTOResponse> getProductsByCategory(String category);
    List<ProductDTOResponse> getProducts();
    ProductDTOResponse updateProduct(Long id, ProductDTOReceive productDTOReceive);
    String deleteProduct(Long id);
}
