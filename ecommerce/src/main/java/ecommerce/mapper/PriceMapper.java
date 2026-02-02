package ecommerce.mapper;

import ecommerce.domain.PriceDomain;
import ecommerce.model.Price;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PriceMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static List<PriceDomain> map(List<Price> priceList) {
        return priceList.stream()
                .map(price -> modelMapper.map(price, PriceDomain.class))
                .collect(Collectors.toList());
    }

    public static PriceDomain mapToDomain(Price price) {
        if (price == null) {
            return null;
        }
        return modelMapper.map(price, PriceDomain.class);
    }
}
