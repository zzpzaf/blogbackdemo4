package com.zzpzaf.se.blogbackdemo4.dbObjects;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleDTO {
    private int articleId;
    private int categoryId;
    private int userId;
    @JsonProperty("cont_type_id")
    private int cont_type_id;
    private String articleTitle;
    private String articleSubTitle;
    private String articleSlug;
    private String articleDescription;
    private String articleContent;
    private int articleStatusId;
    private String articleClientUUID;
    private String articleUUID;
    private Timestamp articleCreationTimestamp;
    private Timestamp articleLastUpdTimestamp;
    private String userSlugName;
    private String userName;
    private String userSurname;

    // Default Constructor
    public ArticleDTO() {}

    // Parameterized Constructor




    public ArticleDTO(int articleId, int categoryId, int userId, int cont_type_id, String articleTitle, String articleSubTitle,
            String articleSlug, String articleDescription, String articleContent, int articleStatusId,
            String articleClientUUID, String articleUUID, Timestamp articleCreationTimestamp,
            Timestamp articleLastUpdTimestamp, String userSlugName, String userName, String userSurname) {
        this.articleId = articleId;
        this.categoryId = categoryId;
        this.userId = userId;
        this.cont_type_id = cont_type_id;    
        this.articleTitle = articleTitle;
        this.articleSubTitle = articleSubTitle;
        this.articleSlug = articleSlug;
        this.articleDescription = articleDescription;
        this.articleContent = articleContent;
        this.articleStatusId = articleStatusId;
        this.articleClientUUID = articleClientUUID;
        this.articleUUID = articleUUID;
        this.articleCreationTimestamp = articleCreationTimestamp;
        this.articleLastUpdTimestamp = articleLastUpdTimestamp;
        this.userSlugName = userSlugName;
        this.userName = userName;
        this.userSurname = userSurname;
    }


    // Getters and Setters
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCont_type_id() {
        return cont_type_id;
    }

    public void setCont_type_id(int cont_type_id) {
        this.cont_type_id = cont_type_id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSubTitle() {
        return articleSubTitle;
    }

    public void setArticleSubTitle(String articleSubTitle) {
        this.articleSubTitle = articleSubTitle;
    }

    public String getArticleSlug() {
        return articleSlug;
    }

    public void setArticleSlug(String articleSlug) {
        this.articleSlug = articleSlug;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    
    public int getArticleStatusId() {
        return articleStatusId;
    }

    public void setArticleStatusId(int articleStatusId) {
        this.articleStatusId = articleStatusId;
    }


    public String getArticleClientUUID() {
        return articleClientUUID;
    }

    public void setArticleClientUUID(String articleClientUUID) {
        this.articleClientUUID = articleClientUUID;
    }


    public String getArticleUUID() {
        return articleUUID;
    }

    public void setArticleUUID(String articleUUID) {
        this.articleUUID = articleUUID;
    }

    
    public Timestamp getArticleCreationTimestamp() {
        return articleCreationTimestamp;
    }

    public void setArticleCreationTimestamp(Timestamp articleCreationTimestamp) {
        this.articleCreationTimestamp = articleCreationTimestamp;
    }

    public Timestamp getArticleLastUpdTimestamp() {
        return articleLastUpdTimestamp;
    }

    public void setArticleLastUpdTimestamp(Timestamp articleLastUpdTimestamp) {
        this.articleLastUpdTimestamp = articleLastUpdTimestamp;
    }

    public String getUserSlugName() {
        return userSlugName;
    }

    public void setUserSlugName(String userSlugName) {
        this.userSlugName = userSlugName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    // Optional: Override toString for debugging
    @Override
    public String toString() {
        return "ArticleDTO{" +
                "articleId=" + articleId +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                ", cont_type_id=" + cont_type_id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleSubTitle='" + articleSubTitle + '\'' +
                ", articleSlug='" + articleSlug + '\'' +
                ", articleDescription='" + articleDescription + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleCreationTimestamp=" + articleCreationTimestamp +
                ", articleLastUpdTimestamp=" + articleLastUpdTimestamp +
                ", userSlugName='" + userSlugName + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                '}';
    }
}
