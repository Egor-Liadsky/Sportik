package com.college.sportik.feature.product.entity;

import com.college.sportik.feature.category.entity.CategoryEntity;
import com.college.sportik.feature.product.entity.characteristic.CharacteristicEntity;
import com.college.sportik.feature.product.entity.dimension.DimensionEntity;
import com.college.sportik.feature.product.entity.image.ImageEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "vendor_code", nullable = false)
    String vendor_code;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "brand", nullable = false)
    String brand;

    @Column(name = "price", nullable = false)
    String price;

    @Column(name = "color", nullable = false)
    String color;

    @OneToOne
    @JoinColumn(name = "category_id")
    CategoryEntity category;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "characteristics_id")
    private List<CharacteristicEntity> characteristics;

    @OneToMany
    @JoinColumn(name = "dimensions_id")
    List<DimensionEntity> dimensions;

    @OneToMany
    @JoinColumn(name = "images_id")
    List<ImageEntity> images;

    public ProductEntity(Integer id, String vendor_code, String title, String description, String brand, String price, String color, CategoryEntity category, List<CharacteristicEntity> characteristics, List<DimensionEntity> dimensions, List<ImageEntity> images) {
        this.id = id;
        this.vendor_code = vendor_code;
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.category = category;
        this.characteristics = characteristics;
        this.dimensions = dimensions;
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public void setVendor_code(String vendor_code) {
        this.vendor_code = vendor_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<CharacteristicEntity> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<CharacteristicEntity> characteristics) {
        this.characteristics = characteristics;
    }

    public List<DimensionEntity> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<DimensionEntity> dimensions) {
        this.dimensions = dimensions;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }
}
