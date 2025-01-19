package Questions.AdvanceConditionalFilter.strategy.filter;

import Questions.AdvanceConditionalFilter.dto.FilterCondition;
import Questions.AdvanceConditionalFilter.enums.ProductAttribute;
import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.attribute_operator.IAttributeOperatorStrategy;
import Questions.AdvanceConditionalFilter.strategy.attribute_operator.PriceAttributeOperator;

import java.util.List;

public class PriceFilter implements IProductAttributeFilter{
    private final IAttributeOperatorStrategy operatorStrategy = new PriceAttributeOperator();

    @Override
    public boolean isAttributeApplicable(ProductAttribute attribute) {
        return attribute == ProductAttribute.PRICE;
    }

    @Override
    public boolean evaluateFilter(Product product, FilterCondition condition) {
        // Validate operator using the strategy
        if (!operatorStrategy.isOperatorValid(condition.getOperator(), condition.getValue())) {
            throw new IllegalArgumentException("Invalid operator or value for PRICE attribute.");
        }

        Object value = condition.getValue();
        double productPrice = product.getPrice();

        // Perform the filtering based on the operator
        return switch (condition.getOperator()) {
            case GREATER_THAN -> productPrice > (Double) value;
            case LESS_THAN -> productPrice < (Double) value;
            case EQUALS -> Math.abs(productPrice - (Double) value) < 0.0001; // Floating-point equality
            case GREATER_THAN_OR_EQUALS -> productPrice >= (Double) value;
            case LESS_THAN_OR_EQUALS -> productPrice <= (Double) value;
            case BETWEEN -> {
                List<Double> range = (List<Double>) value;
                yield productPrice >= range.get(0) && productPrice <= range.get(1);
            }
            default -> false; // Invalid operator
        };
    }

    @Override
    public IAttributeOperatorStrategy getOperatorStrategy() {
        return operatorStrategy;
    }
}
