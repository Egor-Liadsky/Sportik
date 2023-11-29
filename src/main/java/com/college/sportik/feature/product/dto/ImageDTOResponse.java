package com.college.sportik.feature.product.dto;

public class ImageDTOResponse {

    Integer id;
    String title;
    Integer productId;

    @Override
    public String toString() {
        return "ImageDTOResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", productId=" + productId +
                '}';
    }

    public ImageDTOResponse(Integer id, String title, Integer productId) {
        this.id = id;
        this.title = title;
        this.productId = productId;
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
}
