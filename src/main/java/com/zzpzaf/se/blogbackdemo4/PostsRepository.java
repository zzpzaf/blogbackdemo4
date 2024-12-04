package com.zzpzaf.se.blogbackdemo4;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zzpzaf.se.blogbackdemo4.dbObjects.Article;
import com.zzpzaf.se.blogbackdemo4.dbObjects.ArticleDTO;
import com.zzpzaf.se.blogbackdemo4.dbObjects.Category;

@Repository
public class PostsRepository implements IPostsRepository {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;


    static final String CATEGORIES_TABLE = "categories";
    static final String ARTICLES_TABLE = "articles";
    static final String USERS_TABLE = "users";

    @Override
    public List<Category> getCategories() {
        logger.info("PostsRepository - getCategories");
        String sql = "SELECT * FROM " + CATEGORIES_TABLE ;
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
    }

    @Override
    public Category getCategoryById(int id) {
        String selQuery = "SELECT * FROM " + CATEGORIES_TABLE + " WHERE categoryId = ?";
        Category category = new Category();
        try {
            category = jdbcTemplate.queryForObject(selQuery, BeanPropertyRowMapper.newInstance(Category.class), id);
        } catch (Exception e) {
            // logger.info(">===>> PostsRepository ERRORs: " + e.getMessage());
        }
        return category;
    }



    @Override
    public List<Article> getArticles() {
        String sql = "SELECT * FROM " + ARTICLES_TABLE ;
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Article.class));
    }

    @Override
    public List<Article> getCategoryArticles(int id) {
        String sql = "SELECT * FROM " + ARTICLES_TABLE+ " WHERE categoryId = ?";
        List<Article> catArticles = new ArrayList<Article>();
        try {
            catArticles = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Article.class),id);
        } catch (Exception e) {
            // logger.info(">===>> PostsRepository ERRORs: " + e.getMessage());
        }
        return catArticles;
    }


    @Override
    public ArticleDTO getArticleById(int id) {
        // String selQuery = "SELECT * FROM testarticles WHERE articleId = ?";
        String selQuery = String.format("""
            SELECT 
                a.articleId, 
                a.categoryId, 
                a.userId, 
                a.articleTitle, 
                a.articleSubTitle, 
                a.articleSlug, 
                a.articleDescription, 
                a.articleContent, 
                a.articleCreationTimestamp, 
                a.articleLastUpdTimestamp, 
                u.userSlugName, 
                u.userName, 
                u.userSurname 
            FROM %s a 
            JOIN %s u 
            ON a.userId = u.userId 
            WHERE a.articleId = ?;
            """, ARTICLES_TABLE, USERS_TABLE);



        ArticleDTO article = new ArticleDTO();
        try {
            article = jdbcTemplate.queryForObject(selQuery, BeanPropertyRowMapper.newInstance(ArticleDTO.class), id);
        } catch (Exception e) {
            // logger.info(">===>> PostsRepository ERRORs: " + e.getMessage());
        }
        return article;
    }

    @Override
    public ArticleDTO getArticleBySlug(String slug) {
        // String selQuery = "SELECT * FROM testarticles WHERE articleSlug = ?";
        String selQuery = String.format("""
            SELECT 
                a.articleId, 
                a.categoryId, 
                a.userId, 
                a.articleTitle, 
                a.articleSubTitle, 
                a.articleSlug, 
                a.articleDescription, 
                a.articleContent, 
                a.articleCreationTimestamp, 
                a.articleLastUpdTimestamp, 
                u.userSlugName, 
                u.userName, 
                u.userSurname 
            FROM %s a 
            JOIN %s u 
            ON a.userId = u.userId 
            WHERE a.articleSlug = ?;
            """, ARTICLES_TABLE, USERS_TABLE);
        ArticleDTO article = new ArticleDTO();
        try {
            article = jdbcTemplate.queryForObject(selQuery, BeanPropertyRowMapper.newInstance(ArticleDTO.class), slug);
        } catch (Exception e) {
            // logger.info(">===>> PostsRepository ERRORs: " + e.getMessage());
        }
        // logger.info(">===>> PostsRepository article: " + article.toString());
        return article;
    }


}
