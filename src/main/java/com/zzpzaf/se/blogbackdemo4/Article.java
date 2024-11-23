package com.zzpzaf.se.blogbackdemo4;

public class Article {

    private int articleId;
    private int categoryId;
    private String articleTitle;
    private String articleSubTitle;
    private String articleContent;
    private String articleSlug;
    
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
    public String getArticleTitle() {
        return articleTitle;
    }
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
    public String getArticleContent() {
        return articleContent;
    }
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
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
    @Override
    public String toString() {
        return "Article [articleId=" + articleId + ", categoryId=" + categoryId + ", articleTitle=" + articleTitle
                + ", articleSubTitle=" + articleSubTitle + ", articleContent=" + articleContent + ", articleSlug="
                + articleSlug + "]";
    }

    
}
