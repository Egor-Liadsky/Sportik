package com.college.sportik.feature.category.dto;

public class CategoryDTOResponse {

    Integer id;
    String title;
    String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CategoryDTOResponse(Integer id, String title, String code) {
        this.id = id;
        this.title = title;
        this.code = code;
    }
}
