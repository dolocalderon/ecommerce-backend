package ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDomain {
    private Long priceId;
    private Long articleId;
    private Boolean isTemporary;
    private Double amount;
    private Boolean enabled;
}
