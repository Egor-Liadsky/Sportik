package com.college.sportik.feature.product.entity.dimension;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_dimension")
public class SubDimensionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_dimension_id")
    private Integer id;

    private Integer dimension;
}
