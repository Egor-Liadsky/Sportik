package com.college.sportik.feature.product.repository;

import com.college.sportik.feature.product.dto.ProductDTOResponse;
import com.college.sportik.feature.product.entity.ProductEntity;
import com.college.sportik.feature.product.entity.image.ImageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ImageRepository extends CrudRepository<ImageEntity, Long> {

    @Query(value = "select * from image WHERE product_id = ?1", nativeQuery = true)
    ArrayList<ImageEntity> findImagesByProductId(Integer product_id);
}
