package com.college.sportik.feature.product.dto;

import java.util.List;

public class DimensionDTOResponse {

    Integer id;
    String title;
    List<SubDimensionDTOResponse> subDimensions;
    Integer productId;

    @Override
    public String toString() {
        return "DimensionDTOResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subDimensions=" + subDimensions +
                ", productId=" + productId +
                '}';
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

    public List<SubDimensionDTOResponse> getSubDimensions() {
        return subDimensions;
    }

    public void setSubDimensions(List<SubDimensionDTOResponse> subDimensions) {
        this.subDimensions = subDimensions;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
