package Questions.AdvanceConditionalFilter.strategy.filter_expression;

import Questions.AdvanceConditionalFilter.model.Product;

public interface ProductFilterExpression {
    boolean evaluate(Product product);
}
