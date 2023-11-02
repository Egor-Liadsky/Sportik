package com.college.sportik.feature.product.entity.characteristic;

import com.college.sportik.feature.product.entity.ProductEntity;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "characteristic")
public class CharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristics_id", nullable = false)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;

    @OneToMany
    @JoinColumn(name = "sub_characteristic_id")
    List<SubCharacteristicEntity> subCharacteristicEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}