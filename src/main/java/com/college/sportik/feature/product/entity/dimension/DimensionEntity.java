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

    DimensionEntity() {  }

    public DimensionEntity(Integer id, ProductEntity product, String title, List<SubDimensionEntity> subDimensions) {
        this.id = id;
        this.product = product;
        this.title = title;
        this.subDimensions = subDimensions;
    }

    public Integer getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public String getTitle() {
        return title;
    }

    public List<SubDimensionEntity> getSubDimensions() {
        return subDimensions;
    }
}
