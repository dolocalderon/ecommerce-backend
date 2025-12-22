package ecommerce.service.implementations;

import ecommerce.domain.ArticleDomain;
import ecommerce.domain.PriceDomain;
import ecommerce.dto.ArticleDTO;
import ecommerce.mapper.ArticleMapper;
import ecommerce.model.Article;
import ecommerce.model.Price;
import ecommerce.repository.ArticleRepository;
import ecommerce.repository.PriceRepository;
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
    private final PriceRepository priceRepository;

    @Override
    public List<ArticleDTO> getAllArticle() {
        List<Article> articles = articleRepository.findAll();
        List<Price> prices = priceRepository.findByEnabledTrue();
        return ArticleMapper.toDTOList(articles, prices);
    }

    @Override
    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }

}
