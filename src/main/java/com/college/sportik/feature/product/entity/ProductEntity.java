package com.college.sportik.feature.product.entity;

import com.college.sportik.feature.category.entity.CategoryEntity;
import com.college.sportik.feature.product.entity.characteristic.CharacteristicEntity;
import com.college.sportik.feature.product.entity.dimension.DimensionEntity;
import com.college.sportik.feature.product.entity.image.ImageEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(length = 50)
    private String vendorCode;

    @Column
    private String title;

    @Column
    private String description;

    @Column(length = 255)
    private String brand;

    private Integer price;

    @Column(length = 255)
    private String color;

    @OneToOne
    @JoinColumn(name = "category")
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private List<CharacteristicEntity> characteristics;

    @OneToMany(mappedBy = "product")
    private List<DimensionEntity> dimensions;

    @OneToMany(mappedBy = "product")
    private List<ImageEntity> images;
}
