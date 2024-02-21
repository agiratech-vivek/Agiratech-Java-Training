package org.java8features.streams.streamsadvanced;

import java.util.List;

public class Category {
    private String name;
    private List<SubCategory> subCategoryList;

    public Category(String name, List<SubCategory> subCategoryList) {
        this.name = name;
        this.subCategoryList = subCategoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    @Override
    public String toString() {
        return "Category { " +
                "name = '" + name + '\'' +
                ", subCategoryList = " + subCategoryList +
                '}';
    }
}
