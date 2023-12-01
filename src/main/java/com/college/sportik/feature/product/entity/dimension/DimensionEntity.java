package com.college.sportik.feature.product.entity.dimension;

import com.college.sportik.feature.product.entity.ProductEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dimension")
public class DimensionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dimension_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(length = 50)
    private String title;

    @OneToMany(mappedBy = "dimension")
    private List<SubDimensionEntity> subDimensions;


}
