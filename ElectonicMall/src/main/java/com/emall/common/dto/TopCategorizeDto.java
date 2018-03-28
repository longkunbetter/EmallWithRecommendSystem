package com.emall.common.dto;

import com.emall.common.entity.Categorize;

import java.util.List;

public class TopCategorizeDto {
    private Integer id;
    private String name;
    private List<Categorize> subCategorizes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Categorize> getSubCategorizes() {
        return subCategorizes;
    }

    public void setSubCategorizes(List<Categorize> subCategorizes) {
        this.subCategorizes = subCategorizes;
    }
}
