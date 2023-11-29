package com.college.sportik.feature.product.repository;

import com.college.sportik.feature.product.entity.characteristic.CharacteristicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CharacteristicRepository extends CrudRepository<CharacteristicRepository, Long> {

    @Query(value = "select * from characteristic WHERE product_id = ?1", nativeQuery = true)
    ArrayList<CharacteristicEntity> findCharacteristicByProductId(Integer product_id);
}