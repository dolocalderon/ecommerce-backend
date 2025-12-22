package ecommerce.service.interfaces;

import ecommerce.dto.ArticleDTO;
import ecommerce.model.Article;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> getAllArticle();
    Article saveArticle(Article article);
}
