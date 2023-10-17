package com.college.sportik.feature.product.entity.characteristic;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "characteristic")
public class CharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;

//    @OneToOne
//    @PrimaryKeyJoinColumn(name = "sub_characteristic")
//    SubCharacteristicEntity subCharacteristicEntity;
//
//
//    public CharacteristicEntity(Integer id, String title, List<SubCharacteristicEntity> subCharacteristicEntity) {
//        this.id = id;
//        this.title = title;
//        this.subCharacteristicEntity = subCharacteristicEntity;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public List<SubCharacteristicEntity> getSubCharacteristicEntity() {
//        return subCharacteristicEntity;
//    }
//
//    public void setSubCharacteristicEntity(List<SubCharacteristicEntity> subCharacteristicEntity) {
//        this.subCharacteristicEntity = subCharacteristicEntity;
//    }
}
