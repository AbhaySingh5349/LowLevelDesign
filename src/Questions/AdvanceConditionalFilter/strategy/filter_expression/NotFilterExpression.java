package Questions.AdvanceConditionalFilter.strategy.filter_expression;

import Questions.AdvanceConditionalFilter.model.Product;

public class NotFilterExpression implements ProductFilterExpression{
    private final ProductFilterExpression expression;

    public NotFilterExpression(ProductFilterExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean evaluate(Product product) {
        return !expression.evaluate(product);
    }
}
