package com.college.sportik.feature.product.entity.image;

import jakarta.persistence.*;

@Entity(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;
}
