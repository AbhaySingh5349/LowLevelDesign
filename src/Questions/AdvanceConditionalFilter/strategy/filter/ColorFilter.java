package Questions.AdvanceConditionalFilter.strategy.filter;

import Questions.AdvanceConditionalFilter.dto.FilterCondition;
import Questions.AdvanceConditionalFilter.enums.ProductAttribute;
import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.attribute_operator.CategoryAttributeOperator;
import Questions.AdvanceConditionalFilter.strategy.attribute_operator.IAttributeOperatorStrategy;

import java.util.List;

public class ColorFilter implements IProductAttributeFilter{
    private final IAttributeOperatorStrategy operatorStrategy = new CategoryAttributeOperator();
    
    @Override
    public boolean isAttributeApplicable(ProductAttribute attribute) {
        return attribute.equals(ProductAttribute.COLOR);
    }

    @Override
    public boolean evaluateFilter(Product product, FilterCondition condition) {
        // Validate operator using the strategy
        if (!operatorStrategy.isOperatorValid(condition.getOperator(), condition.getValue())) {
            throw new IllegalArgumentException("Invalid operator or value for COLOR attribute.");
        }

        Object value = condition.getValue();
        String productColor = product.getColor();

        return switch (condition.getOperator()) {
            case EQUALS -> productColor.equals(value);
            case CONTAINS -> productColor.contains((String) value);
            case STARTS_WITH -> productColor.startsWith((String) value);
            case ENDS_WITH -> productColor.endsWith((String) value);
            case IN -> {
                List<String> validColors = (List<String>) value;
                yield validColors.contains(productColor);
            }
            default -> false;
        };
    }

    @Override
    public IAttributeOperatorStrategy getOperatorStrategy() {
        return operatorStrategy;
    }
}
