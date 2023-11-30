package com.college.sportik.feature.product.repository;

import com.college.sportik.feature.product.entity.characteristic.SubCharacteristicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SubCharacteristicRepository extends CrudRepository<SubCharacteristicEntity, Long> {

    @Query(value = "select * from sub_characteristic WHERE characteristic_id = ?1", nativeQuery = true)
    ArrayList<SubCharacteristicEntity> findSubCharacteristicByCharacteristicId(Integer characteristic_id);
}