package com.college.sportik.feature.product.dto;

import java.util.List;

public class CharacteristicDTOResponse {

    Integer id;
    String title;
    Integer productId;
    List<SubCharacteristicDTOResponse> subCharacteristic;

    @Override
    public String toString() {
        return "CharacteristicDTOResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", productId=" + productId +
                ", subCharacteristic=" + subCharacteristic +
                '}';
    }

    public CharacteristicDTOResponse(Integer id, String title, Integer productId, List<SubCharacteristicDTOResponse> subCharacteristic) {
        this.id = id;
        this.title = title;
        this.productId = productId;
        this.subCharacteristic = subCharacteristic;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<SubCharacteristicDTOResponse> getSubCharacteristic() {
        return subCharacteristic;
    }

    public void setSubCharacteristic(List<SubCharacteristicDTOResponse> subCharacteristic) {
        this.subCharacteristic = subCharacteristic;
    }
}
