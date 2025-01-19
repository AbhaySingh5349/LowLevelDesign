package Questions.AdvanceConditionalFilter.strategy.filter;

import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.filter_expression.ProductFilterExpression;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilterImpl implements IProductFilter{
    @Override
    public List<Product> filter(List<Product> products, ProductFilterExpression expression) {
        return products.stream()
                .filter(expression::evaluate)
                .collect(Collectors.toList());
    }
}
