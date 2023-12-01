package com.college.sportik.feature.product.repository;

import com.college.sportik.feature.product.entity.dimension.DimensionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DimensionRepository extends CrudRepository<DimensionEntity, Long> {

    @Query(value = "select * from dimension WHERE product_id = ?1", nativeQuery = true)
    ArrayList<DimensionEntity> findDimensionByProductId(Integer product_id);
}
