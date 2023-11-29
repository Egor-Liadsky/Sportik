package com.college.sportik.feature.product.dto;

import java.util.List;

public class ProductDTOResponse {
    Integer id;
    String title;
    String brand;
    String description;
    String color;
    String price;
    String vendorCode;
    String category_id;
    String dateCreated;

    List<CharacteristicDTOResponse> characteristics;
    List<DimensionDTOResponse> dimensions;
    List<ImageDTOResponse> images;

    @Override
    public String toString() {
        return "ProductDTOResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", category_id=" + category_id +
                ", dateCreated='" + dateCreated + '\'' +
                ", characteristics=" + characteristics +
                ", dimensions=" + dimensions +
                ", images=" + images +
                '}';
    }

    public ProductDTOResponse(Integer id, String title, String brand, String description, String color, String price, String vendorCode, String category_id, String dateCreated, List<CharacteristicDTOResponse> characteristics, List<DimensionDTOResponse> dimensions, List<ImageDTOResponse> images) {
        this.id = id;
        this.title = title;
        this.brand = brand;
        this.description = description;
        this.color = color;
        this.price = price;
        this.vendorCode = vendorCode;
        this.category_id = category_id;
        this.dateCreated = dateCreated;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getCategory() {
        return category_id;
    }

    public void setCategory(String category) {
        this.category_id = category;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<CharacteristicDTOResponse> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<CharacteristicDTOResponse> characteristics) {
        this.characteristics = characteristics;
    }

    public List<DimensionDTOResponse> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<DimensionDTOResponse> dimensions) {
        this.dimensions = dimensions;
    }

    public List<ImageDTOResponse> getImages() {
        return images;
    }

    public void setImages(List<ImageDTOResponse> images) {
        this.images = images;
    }
}
