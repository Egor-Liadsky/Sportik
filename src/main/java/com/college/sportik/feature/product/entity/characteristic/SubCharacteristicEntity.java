package com.college.sportik.feature.product.entity.characteristic;

import jakarta.persistence.*;

@Entity(name = "sub_characteristic")
public class SubCharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description", nullable = false)
    String description;
}
