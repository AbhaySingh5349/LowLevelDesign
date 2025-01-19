package Questions.AdvanceConditionalFilter.strategy.filter;

import Questions.AdvanceConditionalFilter.dto.FilterCondition;
import Questions.AdvanceConditionalFilter.enums.ProductAttribute;
import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.attribute_operator.BrandAttributeOperator;
import Questions.AdvanceConditionalFilter.strategy.attribute_operator.IAttributeOperatorStrategy;

import java.util.List;

public class BrandFilter implements IProductAttributeFilter{
    private final IAttributeOperatorStrategy operatorStrategy = new BrandAttributeOperator();

    @Override
    public boolean isAttributeApplicable(ProductAttribute attribute) {
        return attribute == ProductAttribute.BRAND;
    }

    @Override
    public boolean evaluateFilter(Product product, FilterCondition condition) {
        // Validate operator using the strategy
        if (!operatorStrategy.isOperatorValid(condition.getOperator(), condition.getValue())) {
            throw new IllegalArgumentException("Invalid operator or value for BRAND attribute.");
        }

        Object value = condition.getValue();
        String productBrand = product.getBrand();

        return switch (condition.getOperator()) {
            case EQUALS -> productBrand.equals(value);
            case CONTAINS -> productBrand.contains((String) value);
            case STARTS_WITH -> productBrand.startsWith((String) value);
            case ENDS_WITH -> productBrand.endsWith((String) value);
            case IN -> {
                List<String> validBrands = (List<String>) value;
                yield validBrands.contains(productBrand);
            }
            default -> false;
        };
    }

    @Override
    public IAttributeOperatorStrategy getOperatorStrategy() {
        return operatorStrategy;
    }
}
