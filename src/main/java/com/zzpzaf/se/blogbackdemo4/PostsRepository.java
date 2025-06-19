package com.zzpzaf.se.blogbackdemo4;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zzpzaf.se.blogbackdemo4.dbObjects.Article;
import com.zzpzaf.se.blogbackdemo4.dbObjects.ArticleDTO;
import com.zzpzaf.se.blogbackdemo4.dbObjects.Category;
import com.zzpzaf.se.blogbackdemo4.dbObjects.ContentType;

@Repository
public class PostsRepository implements IPostsRepository {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    static final String CATEGORIES_TABLE = "categories";
    static final String ARTICLES_TABLE = "articles";
    static final String USERS_TABLE = "users";
    static final String CONTENT_TYPES_TABLE = "content_types";

    @Override
    public List<Category> getCategories() {
        logger.info("PostsRepository - getCategories");
        String sql = "SELECT * FROM " + CATEGORIES_TABLE;
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
    public List<ContentType> getContentTypes () {
        logger.info("PostsRepository - getContentTypess");
        String sql = "SELECT * FROM " + CONTENT_TYPES_TABLE;
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ContentType.class));
    }

    public ContentType getContentTypeById(int id) {
        String selQuery = "SELECT * FROM " + CONTENT_TYPES_TABLE + " WHERE cont_type_id = ?";
        ContentType contentType = new ContentType();
        try {
            contentType = jdbcTemplate.queryForObject(selQuery, BeanPropertyRowMapper.newInstance(ContentType.class), id);
        } catch (Exception e) {
            // logger.info(">===>> PostsRepository ERRORs: " + e.getMessage());
        }
        return contentType;
    }




    @Override
    public List<Article> getArticles() {
        String sql = "SELECT * FROM " + ARTICLES_TABLE;
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Article.class));
    }

    @Override
    public List<Article> getCategoryArticles(int id) {
        String sql = "SELECT * FROM " + ARTICLES_TABLE + " WHERE categoryId = ?";
        List<Article> catArticles = new ArrayList<Article>();
        try {
            catArticles = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Article.class), id);
        } catch (Exception e) {
            // logger.info(">===>> PostsRepository ERRORs: " + e.getMessage());
        }
        return catArticles;
    }

    @Override
    public ArticleDTO getArticleDTOById(int id) {
        // String selQuery = "SELECT * FROM testarticles WHERE articleId = ?";
        String selQuery = String.format("""
                SELECT
                    a.articleId,
                    a.categoryId,
                    a.userId,
                    a.cont_type_id,
                    a.articleTitle,
                    a.articleSubTitle,
                    a.articleSlug,
                    a.articleDescription,
                    a.articleContent,
                    a.articleStatusId,
                    a.articleClientUUID,
                    a.articleUUID,
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
            logger.info(">===>> PostsRepository getArticleDTOById() : " + article.getArticleClientUUID());
        } catch (Exception e) {
            // logger.info(">===>> PostsRepository ERRORs: " + e.getMessage());
        }
        return article;
    }

    @Override
    public ArticleDTO getArticleDTOBySlug(String slug) {
        // String selQuery = "SELECT * FROM testarticles WHERE articleSlug = ?";
        String selQuery = String.format("""
                SELECT
                    a.articleId,
                    a.categoryId,
                    a.userId,
                    a.cont_type_id,
                    a.articleTitle,
                    a.articleSubTitle,
                    a.articleSlug,
                    a.articleDescription,
                    a.articleContent,
                    a.articleStatusId,
                    a.articleClientUUID,
                    a.articleUUID,
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

    @Override
    @Transactional(rollbackFor = java.lang.Exception.class)
    public ArticleDTO addArticle(Article newArticle) {
        int status = 0;
        String uuid = UUID.randomUUID().toString();
        newArticle.setArticleClientUUID(uuid);
        logger.info(">===>> PostsRepository - addArticle() - New Article UUID: " + uuid + " - " + newArticle.getArticleClientUUID());
        // newArticle.setArticleStatusId(0);
        String insQuery = "INSERT INTO " + ARTICLES_TABLE + " ( " +
                "categoryId, " +
                "userId, " +
                "articleTitle, " +
                "articleSubTitle, " +
                "articleSlug, " +
                "articleDescription, " +
                "cont_type_id = ?, " +
                "articleContent, " +
                "articleClientUUID" +
                ")" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // logger.info(">===>> PostsRepository - addArticle() - Adding Article: " + newArticle.toString());
        try {
            status = jdbcTemplate.update(insQuery, newArticle.getCategoryId(), newArticle.getUserId(),
                    newArticle.getArticleTitle(), newArticle.getArticleSubTitle(), newArticle.getArticleSlug(),
                    newArticle.getArticleDescription(), newArticle.getCont_type_id(), newArticle.getArticleContent(), newArticle.getArticleClientUUID() );
        } catch (Exception e) {
            logger.error(">===>> PostsRepository - addArticle() - ERRORs: " + e.getMessage());
        }
        if (status == 1) {
            logger.info(">===>> " + "PostsRepository " + "addArticle: " + newArticle.toString());
            return getArticleByClientUUID(uuid);
        }        

        return null;        

    }


    @Override
    @Transactional(rollbackFor = java.lang.Exception.class)
    public ArticleDTO updateArticle(Article article) {
        int status = 0;
        logger.info(">===>> PostsRepository - updateArticle() - Article UUID: " + article.getArticleClientUUID());
        String updateQuery = "UPDATE " + ARTICLES_TABLE + " SET " +
                "categoryId = ?, " +
                "userId = ?, " +
                "articleTitle = ?, " +
                "articleSubTitle = ?, " +
                "articleSlug = ?, " +
                "articleDescription = ?, " +
                "cont_type_id = ?, " +
                "articleContent = ? " +
                "WHERE articleUUID = ?";

        try {
            status = jdbcTemplate.update(updateQuery, article.getCategoryId(), article.getUserId(),
                    article.getArticleTitle(), article.getArticleSubTitle(), article.getArticleSlug(),
                    article.getArticleDescription(), article.getCont_type_id(), article.getArticleContent(), article.getArticleUUID());
            // logger.info(">===>> PostsRepository - updateArticle() - status: " + status ); 
        } catch (Exception e) {
            logger.error(">===>> PostsRepository - updateArticle() - ERRORs: " + e.getMessage());
        }
        if (status == 1) {
            // logger.info(">===>> " + "PostsRepository " + "updateArticle: " + article.toString());
            return getArticleByUUID(article.getArticleUUID());
        }        

        return null;        

    }




    @Override
    public ArticleDTO getArticleByClientUUID(String uuid) {
        String selQuery = String.format("""
                SELECT
                    a.articleId,
                    a.categoryId,
                    a.userId,
                    a.cont_type_id,
                    a.articleTitle,
                    a.articleSubTitle,
                    a.articleSlug,
                    a.articleDescription,
                    a.articleContent,
                    a.articleStatusId,
                    a.articleClientUUID,
                    a.articleUUID,
                    a.articleCreationTimestamp,
                    a.articleLastUpdTimestamp,
                    u.userSlugName,
                    u.userName,
                    u.userSurname
                FROM %s a
                JOIN %s u
                ON a.userId = u.userId
                WHERE a.articleClientUUID = ?;
                """, ARTICLES_TABLE, USERS_TABLE);
        ArticleDTO article = new ArticleDTO();
        try {
            article = jdbcTemplate.queryForObject(selQuery, BeanPropertyRowMapper.newInstance(ArticleDTO.class), uuid);
        } catch (Exception e) {
            logger.info(">===>> PostsRepository  getArticleByClientUUID() ERRORs: " + e.getMessage());
        }
        return article;
    }

    @Override
    public ArticleDTO getArticleByUUID(String uuid) {
        String selQuery = String.format("""
                SELECT
                    a.articleId,
                    a.categoryId,
                    a.userId,
                    a.cont_type_id,
                    a.articleTitle,
                    a.articleSubTitle,
                    a.articleSlug,
                    a.articleDescription,
                    a.articleContent,
                    a.articleStatusId,
                    a.articleClientUUID,
                    a.articleUUID,
                    a.articleCreationTimestamp,
                    a.articleLastUpdTimestamp,
                    u.userSlugName,
                    u.userName,
                    u.userSurname
                FROM %s a
                JOIN %s u
                ON a.userId = u.userId
                WHERE a.articleUUID = ?;
                """, ARTICLES_TABLE, USERS_TABLE);
        ArticleDTO article = new ArticleDTO();
        try {
            article = jdbcTemplate.queryForObject(selQuery, BeanPropertyRowMapper.newInstance(ArticleDTO.class), uuid);
        } catch (Exception e) {
            logger.info(">===>> PostsRepository getArticleByUUID() - ERRORs: " + e.getMessage());
        }
        // logger.info(">===>> PostsRepository article: " + article.toString());
        return article;
    }



}
