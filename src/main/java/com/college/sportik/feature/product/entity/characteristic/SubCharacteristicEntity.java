package com.college.sportik.feature.product.entity.characteristic;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_characteristic")
public class SubCharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_characteristic_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteristic_id")
    private CharacteristicEntity characteristic;

    @Column
    private String title;

    @Column
    private String description;

    SubCharacteristicEntity() {  }

    public SubCharacteristicEntity(Integer id, CharacteristicEntity characteristic, String title, String description) {
        this.id = id;
        this.characteristic = characteristic;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public CharacteristicEntity getCharacteristic() {
        return characteristic;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
