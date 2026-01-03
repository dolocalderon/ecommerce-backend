package ecommerce.mapper;

import ecommerce.domain.ArticleDomain;
import ecommerce.domain.PriceDomain;
import ecommerce.dto.ArticleDTO;
import ecommerce.model.Article;
import ecommerce.model.Price;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArticleMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static List<ArticleDomain> map(List<Article> articleList) {
        return articleList.stream()
                .map(article -> modelMapper.map(article, ArticleDomain.class))
                .collect(Collectors.toList());
    }

    public static List<ArticleDTO> toDTOList(List<Article> articles, List<Price> prices) {

        Map<Long, Price> priceByArticleId = prices.stream()
                .collect(Collectors.toMap(
                        Price::getArticleId,
                        price -> price
                ));

        return articles.stream()
                .filter(article -> priceByArticleId.containsKey(article.getId()))
                .map(article -> toDTO(article, priceByArticleId.get(article.getId())))
                .collect(Collectors.toList());
    }

    private static ArticleDTO toDTO(Article article, Price price) {

        return ArticleDTO.builder()
                .id(article.getId())
                .code(article.getCode())
                .name(article.getName())
                .description(article.getDescription())
                .category(article.getCategory())
                .brand(article.getBrand())
                .price(PriceMapper.mapToDomain(price))
                .build();
    }

}
