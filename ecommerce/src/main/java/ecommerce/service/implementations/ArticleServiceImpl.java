package ecommerce.service.implementations;

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

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final PriceRepository priceRepository;

    @Override
    public List<ArticleDTO> getAllArticle() {

        return articleRepository.findAll().stream()
                .map(article -> {
                    Price price = priceRepository
                            .findByArticleIdAndEnabledTrue(article.getId())
                            .orElse(null);

                    return ArticleMapper.toDTO(article, price);
                })
                .toList();
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }
}

