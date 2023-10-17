package com.college.sportik.feature.product.entity;

import jakarta.persistence.*;

@Entity(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "vendor_code", nullable = false)
    String vendor_code;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "brand", nullable = false)
    String brand;

    @Column(name = "price", nullable = false)
    String price;

    @Column(name = "color", nullable = false)
    String color;

//    @OneToOne
//    @PrimaryKeyJoinColumn(name = "category")
//    CategoryEntity category;
//
//    @OneToMany
//    @Column(name = "characteristics")
//    List<CharacteristicEntity> characteristics;

//    @OneToMany
//    @Column(name = "dimensions")
//    List<DimensionEntity> dimensions;
//
//    @OneToMany
//    @Column(name = "images")
//    List<ImageEntity> images;

    ProductEntity() {
    }
}
