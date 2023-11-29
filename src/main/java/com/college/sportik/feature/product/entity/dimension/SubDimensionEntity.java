package com.college.sportik.feature.product.entity.dimension;

import com.college.sportik.feature.product.entity.characteristic.CharacteristicEntity;
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

    private Integer size;
}
