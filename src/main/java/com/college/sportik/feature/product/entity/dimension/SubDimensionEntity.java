package com.college.sportik.feature.product.entity.dimension;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_dimension")
public class SubDimensionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_dimension_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dimension_id")
    private DimensionEntity dimension;

    private String size;

    SubDimensionEntity() {  }

    public SubDimensionEntity(Integer id, DimensionEntity dimension, String size) {
        this.id = id;
        this.dimension = dimension;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public DimensionEntity getDimension() {
        return dimension;
    }

    public String getSize() {
        return size;
    }
}
