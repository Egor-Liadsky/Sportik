package com.college.sportik.feature.product.repository;

import com.college.sportik.feature.product.entity.dimension.SubDimensionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SubDimensionRepository extends CrudRepository<SubDimensionEntity, Long> {

    @Query(value = "select * from sub_dimension WHERE dimension_id = ?1", nativeQuery = true)
    ArrayList<SubDimensionEntity> findSubDimensionByDimensionId(Integer dimension_id);
}