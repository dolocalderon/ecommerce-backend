package ecommerce.repository;

import ecommerce.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceRepository  extends JpaRepository<Price, Long> {
        Optional<Price> findByArticleIdAndEnabledTrue(Long articleId);
}
