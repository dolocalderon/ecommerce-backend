package ecommerce.dto;

import ecommerce.domain.PriceDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    //ARTICLE
    private Long id;
    private String code;
    private String name;
    private String description;
    private String category;
    private String brand;
    //PRICE
    private PriceDomain price;
}
