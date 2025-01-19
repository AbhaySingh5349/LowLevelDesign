package Questions.AdvanceConditionalFilter.dto;

import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.attribute_operator.IAttributeOperatorStrategy;
import Questions.AdvanceConditionalFilter.strategy.filter.IProductAttributeFilter;

import java.util.List;

public class ProductFilterSystem {
    private final List<IProductAttributeFilter> filters;

    public ProductFilterSystem(List<IProductAttributeFilter> filters) {
        this.filters = filters;
    }

    public boolean evaluateProduct(Product product, FilterCondition condition) {
        for (IProductAttributeFilter filter : filters) {
            if (filter.isAttributeApplicable(condition.getAttribute())) {
                // Validate operator using the strategy
                IAttributeOperatorStrategy operatorStrategy = filter.getOperatorStrategy();
                if (!operatorStrategy.isOperatorValid(condition.getOperator(), condition.getValue())) {
                    throw new IllegalArgumentException("Invalid operator or value for attribute: " + condition.getAttribute());
                }

                return filter.evaluateFilter(product, condition);
            }
        }
        throw new IllegalArgumentException("No filter found for attribute: " + condition.getAttribute());
    }

    public boolean evaluateComplexConditions(Product product, List<FilterCondition> conditions) {
        for (FilterCondition condition : conditions) {
            if (!evaluateProduct(product, condition)) {
                return false; // Fails any condition
            }
        }
        return true; // Passes all conditions
    }
}
