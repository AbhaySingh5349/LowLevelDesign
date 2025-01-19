package Questions.AdvanceConditionalFilter.strategy.filter_expression;

import Questions.AdvanceConditionalFilter.model.Product;

public class OrFilterExpression implements ProductFilterExpression{
    private final ProductFilterExpression left;
    private final ProductFilterExpression right;

    public OrFilterExpression(ProductFilterExpression left, ProductFilterExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean evaluate(Product product) {
        return left.evaluate(product) || right.evaluate(product);
    }
}
