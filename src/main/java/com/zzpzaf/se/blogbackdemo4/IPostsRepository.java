package com.zzpzaf.se.blogbackdemo4;

import java.util.List;

import com.zzpzaf.se.blogbackdemo4.dbObjects.Article;
import com.zzpzaf.se.blogbackdemo4.dbObjects.ArticleDTO;
import com.zzpzaf.se.blogbackdemo4.dbObjects.Category;
import com.zzpzaf.se.blogbackdemo4.dbObjects.ContentType;
public interface IPostsRepository {

    List<Category> getCategories();
    Category getCategoryById(int id);

    List<ContentType> getContentTypes();
    ContentType getContentTypeById(int id);


    List<Article> getArticles(); 
    List<Article> getCategoryArticles(int id); 

    ArticleDTO getArticleByClientUUID(String uuid);
    ArticleDTO getArticleByUUID(String uuid);

    ArticleDTO getArticleDTOById(int id);
    ArticleDTO getArticleDTOBySlug(String slug);

    ArticleDTO addArticle(Article newArticle);
    ArticleDTO updateArticle(Article newArticle);



}


