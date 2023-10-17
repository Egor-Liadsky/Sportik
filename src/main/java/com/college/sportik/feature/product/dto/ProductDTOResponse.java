package com.college.sportik.feature.product.dto;

public class ProductDTOResponse {
    Integer id;
    String title;
    String description;
    String category;
    String dateCreated;
    Integer views;

    public ProductDTOResponse(Integer id, String title, String description, String category, String dateCreated, Integer views) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.dateCreated = dateCreated;
        this.views = views;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
