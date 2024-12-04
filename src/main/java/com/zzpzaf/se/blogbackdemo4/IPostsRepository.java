package com.zzpzaf.se.blogbackdemo4;

import java.util.List;

import com.zzpzaf.se.blogbackdemo4.dbObjects.Article;
import com.zzpzaf.se.blogbackdemo4.dbObjects.ArticleDTO;
import com.zzpzaf.se.blogbackdemo4.dbObjects.Category;

public interface IPostsRepository {

    List<Category> getCategories();

    Category getCategoryById(int id);


    List<Article> getArticles(); 
    List<Article> getCategoryArticles(int id); 

    ArticleDTO getArticleById(int id);
    ArticleDTO getArticleBySlug(String slug);

}


