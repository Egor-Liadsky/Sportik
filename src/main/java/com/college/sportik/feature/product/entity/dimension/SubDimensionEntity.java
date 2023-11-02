package com.college.sportik.feature.product.entity.dimension;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_dimension")
public class SubDimensionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "dimension", nullable = false)
    String dimension;
}
