package ecommerce.mapper;

import ecommerce.domain.ArticleDomain;
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

    public static ArticleDTO toDTO(Article article, Price price) {
        return ArticleDTO.builder()
                .id(article.getId())
                .code(article.getCode())
                .name(article.getName())
                .description(article.getDescription())
                .category(article.getCategory().getName())
                .brand(article.getBrand().getName())
                .price(PriceMapper.mapToDomain(price))
                .build();
    }

}
