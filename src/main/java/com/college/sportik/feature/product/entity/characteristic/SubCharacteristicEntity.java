package com.college.sportik.feature.product.entity.characteristic;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_characteristic")
public class SubCharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_characteristic_id", nullable = false)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description", nullable = false)
    String description;
}
