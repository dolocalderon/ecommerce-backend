package ecommerce.service.implementations;

import ecommerce.model.Article;
import ecommerce.repository.ArticleRepository;
import ecommerce.service.interfaces.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticle(){
        return articleRepository.findAll();
    }

    @Override
    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }

}
