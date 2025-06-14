package com.zzpzaf.se.blogbackdemo4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zzpzaf.se.blogbackdemo4.dbObjects.Article;
import com.zzpzaf.se.blogbackdemo4.dbObjects.ArticleDTO;
import com.zzpzaf.se.blogbackdemo4.dbObjects.Category;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PostsController {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private IPostsRepository postsRepository;
    
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        logger.info("PostsController - Categories");
        List<Category> returnCategoriesList = new ArrayList<>();
        try {
            returnCategoriesList = postsRepository.getCategories();
            if (returnCategoriesList.size() > 0) {
                return new ResponseEntity<>(returnCategoriesList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // logger.info(">===>> PostsController /categories ERRORs: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/categories" + "/categoryId/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category category;
        category = postsRepository.getCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getArticles() {
        List<Article> returnArticlesList = new ArrayList<>();
        try {
            returnArticlesList = postsRepository.getArticles();
            // logger.info(returnCategoriesList);
            if (returnArticlesList.size() > 0) {
                return new ResponseEntity<>(returnArticlesList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // logger.info(">===>> PostsController /articles ERRORs: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/articles"+ "/categoryId/{id}")
    public ResponseEntity<List<Article>> getCategoryArticles(@PathVariable int id) {
        List<Article> returnCategoriesList = new ArrayList<>();
        try {
            returnCategoriesList = postsRepository.getCategoryArticles(id);
            // logger.info(returnCategoriesList);
            if (returnCategoriesList.size() > 0) {
                return new ResponseEntity<>(returnCategoriesList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // logger.info(">===>> PostsController /articles/categoryId/ ERRORs: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/articles" + "/articleId/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable int id) {
        ArticleDTO article;
        article = postsRepository.getArticleDTOById(id);
        if (article != null) {
            return new ResponseEntity<>(article, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/articles" + "/articleSlug/{slug}")
    public ResponseEntity<ArticleDTO> getArticleBySlug(@PathVariable String slug) {
        ArticleDTO article;
        article = postsRepository.getArticleDTOBySlug(slug);
        if (article != null) {
            return new ResponseEntity<>(article, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/articles")
    public ResponseEntity<ArticleDTO> addArticle(@RequestBody Article article) {
            ArticleDTO addedArticle = postsRepository.addArticle(article);
            if (addedArticle != null) {
                return new ResponseEntity<>(addedArticle, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
            }
    }
    
    @PatchMapping(value = "/articles")
    public ResponseEntity<ArticleDTO> updateArticle(@RequestBody Article article) {
        ArticleDTO updatedArticle = postsRepository.updateArticle(article);
        if (updatedArticle != null) {
            return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }


}
