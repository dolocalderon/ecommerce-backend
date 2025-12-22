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
        //INDEXAR PRECIOS A LOS ARTICULOS
        Map<Long, List<Price>> pricesByArticleId = prices.stream().collect(Collectors.groupingBy(Price::getArticleId));
        //ARMAR DTO
        return articles.stream().map(article -> toDTO(article, pricesByArticleId.get(article.getId()))).toList();
    }

    private static ArticleDTO toDTO(Article article, List<Price> prices) {
        List<PriceDomain> priceDomains = prices == null
                        ? List.of()
                        : prices.stream()
                        .map(PriceMapper::mapToDomain)
                        .toList();

        return ArticleDTO.builder()
                .id(article.getId())
                .code(article.getCode())
                .name(article.getName())
                .description(article.getDescription())
                .category(article.getCategory())
                .brand(article.getBrand())
                .price(priceDomains)
                .build();
    }

}
