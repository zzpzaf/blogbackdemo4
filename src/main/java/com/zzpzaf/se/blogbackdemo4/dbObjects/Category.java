package com.zzpzaf.se.blogbackdemo4.dbObjects;

public class Category {

    private int categoryId;
    private String categoryTitle;
    private int categoryStatusId;
    private String categoryUUID;

    // Default Constructor
    public Category() {}

    // Parameterized Constructor
    public Category(int categoryId, String categoryTitle, int categoryStatusId, String categoryUUID) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryStatusId = categoryStatusId;
        this.categoryUUID = categoryUUID;
    }

    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public int getCategoryStatusId() {
        return categoryStatusId;
    }

    public void setCategoryStatusId(int categoryStatusId) {
        this.categoryStatusId = categoryStatusId;
    }

    public String getCategoryUUID() {
        return categoryUUID;
    }

    public void setCategoryUUID(String categoryUUID) {
        this.categoryUUID = categoryUUID;
    }

    // Optional: Override toString for easy debugging
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryTitle='" + categoryTitle + '\'' +
                ", categoryStatusId=" + categoryStatusId +
                ", categoryUUID='" + categoryUUID + '\'' +
                '}';
    }

}
