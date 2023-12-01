package com.college.sportik.feature.product.dto;

public class SubCharacteristicDTOResponse {

    Integer id;
    String title;
    String description;
    Integer characteristicId;

    public SubCharacteristicDTOResponse(Integer id, String title, String description, Integer characteristicId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.characteristicId = characteristicId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(Integer characteristicId) {
        this.characteristicId = characteristicId;
    }
}
