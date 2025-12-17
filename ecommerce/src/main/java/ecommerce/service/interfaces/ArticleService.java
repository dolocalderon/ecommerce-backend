package ecommerce.service.interfaces;

import ecommerce.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();

    Article saveArticle(Article article);
}
