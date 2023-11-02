package com.college.sportik.feature.product.entity.dimension;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dimension")
public class DimensionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dimensions_id", nullable = false)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;

//    @OneToMany(mappedBy = "dimension", cascade = CascadeType.ALL)
//    @Column(name = "dimension", nullable = false)
//    List<SubDimensionEntity> dimension;
}
