package com.college.sportik.feature.product.entity.characteristic;

import com.college.sportik.feature.product.entity.ProductEntity;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "characteristic")
public class CharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(length = 255)
    private String title;

    @OneToMany
    @JoinTable(name = "sub_characteristic")
    private List<SubCharacteristicEntity> subCharacteristics;

    public CharacteristicEntity(Integer id, ProductEntity product, String title, List<SubCharacteristicEntity> subCharacteristics) {
        this.id = id;
        this.product = product;
        this.title = title;
        this.subCharacteristics = subCharacteristics;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubCharacteristicEntity> getSubCharacteristics() {
        return subCharacteristics;
    }

    public void setSubCharacteristics(List<SubCharacteristicEntity> subCharacteristics) {
        this.subCharacteristics = subCharacteristics;
    }
}