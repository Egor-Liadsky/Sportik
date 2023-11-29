package com.college.sportik.feature.product.service;

import com.college.sportik.feature.product.dto.ProductDTOReceive;
import com.college.sportik.feature.product.dto.ProductDTOResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductDTOResponse createProduct(ProductDTOResponse productDTOResponse);

    List<ProductDTOReceive> getProducts();
}
