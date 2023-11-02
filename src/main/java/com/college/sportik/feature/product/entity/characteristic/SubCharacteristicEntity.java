package com.college.sportik.feature.product.entity.characteristic;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_characteristic")
public class SubCharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_characteristic_id")
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;
}
