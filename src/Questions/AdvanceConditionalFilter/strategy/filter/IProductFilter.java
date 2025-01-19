package Questions.AdvanceConditionalFilter.strategy.filter;

import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.filter_expression.ProductFilterExpression;

import java.util.List;

public interface IProductFilter {
    List<Product> filter(List<Product> products, ProductFilterExpression expression);
}
