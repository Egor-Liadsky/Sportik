package com.college.sportik.feature.product.entity.image;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "images_id", nullable = false)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;
}
