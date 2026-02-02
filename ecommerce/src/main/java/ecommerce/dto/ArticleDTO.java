package ecommerce.dto;

import ecommerce.domain.PriceDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    //ARTICLE
    private Long id;
    private String code;
    private String name;
    private String description;

    //CATEGORY
    private String category;

    //BRAND
    private String brand;

    //PRICE
    private PriceDomain price;
}

