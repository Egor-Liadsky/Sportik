package com.college.sportik.feature.product.service;

import com.college.sportik.feature.product.dto.ProductDTOReceive;
import com.college.sportik.feature.product.dto.ProductDTOResponse;
import com.college.sportik.feature.product.entity.ProductEntity;
import com.college.sportik.feature.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTOResponse createProduct(ProductDTOResponse productDTOResponse) {
        return null;
    }

//    @Override
//    public ProductDTOResponse createProduct(ProductDTOResponse productDTOResponse) {
//        if (productRepository.findById(productDTOResponse.getId()) == null) {
//            productRepository.save(new ProductEntity(
//                    productDTOResponse.getId(),
//                    productDTOResponse.getTitle(),
//                    productDTOResponse.getDescription(),
//                    productDTOResponse.getCategory(),
//                    productDTOResponse.getDateCreated()
////                    productDTOResponse.getViews()
//            ));
//            return productRepository.findById(productDTOResponse.getId());
//        } else {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product already exists");
//        }
//    }

    @Override
    public Optional<ProductDTOResponse> getProductById(Long id) {
//        Optional<ProductEntity> product = productRepository.findById(id);
//        if (product.isPresent()) {
//            return product.map(item ->
//                    new ProductDTOResponse(item.getId(), item.getTitle(), item.getDescription(), item.getCategory(), item.getDateCreated(), item.getViews())
//            );
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
//        }
        return null;
    }

    @Override
    public List<ProductDTOResponse> getProductsByCategory(String category) {
        return null;
    }

    @Override
    public List<ProductDTOResponse> getProducts() {
        return null;
    }

    @Override
    public ProductDTOResponse updateProduct(Long id, ProductDTOReceive productDTOReceive) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product with id " + id + " deleted";
    }
}
