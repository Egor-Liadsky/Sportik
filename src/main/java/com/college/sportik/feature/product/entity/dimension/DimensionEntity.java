package com.college.sportik.feature.product.entity.dimension;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "dimension")
public class DimensionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;

//    @OneToMany(mappedBy = "dimension", cascade = CascadeType.ALL)
//    @Column(name = "dimension", nullable = false)
//    List<SubDimensionEntity> dimension;
}
