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
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String brand;

    private String price;

    @Column
    private String color;

    @Column(name = "date_created")
    private String dateCreated;

    @ManyToOne
    @JoinColumn(name = "category")
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private List<CharacteristicEntity> characteristics;

    @OneToMany(mappedBy = "product")
    private List<DimensionEntity> dimensions;

    @OneToMany(mappedBy = "product")
    private List<ImageEntity> images;

    ProductEntity() { }

    public ProductEntity(Integer id, String vendorCode, String title, String description, String brand, String price, String color, String dateCreated, CategoryEntity category, List<CharacteristicEntity> characteristics, List<DimensionEntity> dimensions, List<ImageEntity> images) {
        this.id = id;
        this.vendorCode = vendorCode;
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.dateCreated = dateCreated;
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

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
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
