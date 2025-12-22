package ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "priceId")
    private Long priceId;

    @Column(name = "articleId")
    private Long articleId;

    @Column(name = "isTemporary")
    private Boolean isTemporary;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "enabled")
    private Boolean enabled;
}
