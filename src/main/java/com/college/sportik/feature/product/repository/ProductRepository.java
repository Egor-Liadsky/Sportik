package com.college.sportik.feature.product.repository;

import com.college.sportik.feature.product.dto.ProductDTOResponse;
import com.college.sportik.feature.product.entity.ProductEntity;
import com.college.sportik.feature.product.entity.image.ImageEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query(value = "select * from product WHERE vendor_code = ?1", nativeQuery = true)
    ProductEntity findByVendorCode(String vendorCode);

    @Query(value = "select * from product WHERE product_id = ?1", nativeQuery = true)
    ProductEntity findProductById(Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into image (image_id, title, product_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void createImage(Integer id, String title, Integer product_id);

    @Modifying
    @Transactional
    @Query(value = "insert into dimension (dimension_id, title, product_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void createDimension(Integer id, String title, Integer product_id);

    @Modifying
    @Transactional
    @Query(value = "insert into sub_dimension (sub_dimension_id, size, dimension_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void createSubDimension(Integer id, String size, Integer dimension_id);

    @Modifying
    @Transactional
    @Query(value = "insert into characteristic (characteristic_id, title, product_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void createCharacteristic(Integer id, String title, Integer product_id);

    @Modifying
    @Transactional
    @Query(value = "insert into sub_characteristic (sub_characteristic_id, description, title, characteristic_id) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void createSubCharacteristic(Integer id, String description, String title, Integer characteristic);
}
