package com.college.sportik.feature.product.service;

import com.college.sportik.feature.product.dto.ProductDTOReceive;
import com.college.sportik.feature.product.dto.ProductDTOResponse;
import com.college.sportik.feature.product.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductDTOResponse createProduct(ProductDTOResponse productDTOResponse);
    ProductDTOReceive getProductById(Long id);
    List<ProductDTOReceive> getProducts();
}
