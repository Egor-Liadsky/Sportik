package com.college.sportik.feature.product.dto;

public class SubDimensionDTOResponse {

    Integer id;
    Integer size;
    Integer dimensionId;

    @Override
    public String toString() {
        return "SubDimensionDTOResponse{" +
                "id=" + id +
                ", size=" + size +
                ", dimensionId=" + dimensionId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(Integer dimensionId) {
        this.dimensionId = dimensionId;
    }
}
