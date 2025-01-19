package Questions.AdvanceConditionalFilter.strategy.filter_expression;

import Questions.AdvanceConditionalFilter.dto.FilterCondition;
import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.filter.IProductAttributeFilter;

public class ConditionExpression implements ProductFilterExpression{
    private final IProductAttributeFilter filter;
    private final FilterCondition condition;

    public ConditionExpression(IProductAttributeFilter filter, FilterCondition condition) {
        this.filter = filter;
        this.condition = condition;
    }

    @Override
    public boolean evaluate(Product product) {
        return filter.evaluateFilter(product, condition);
    }
}
