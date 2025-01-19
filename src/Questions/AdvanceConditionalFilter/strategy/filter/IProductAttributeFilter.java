package Questions.AdvanceConditionalFilter.strategy.filter;

import Questions.AdvanceConditionalFilter.dto.FilterCondition;
import Questions.AdvanceConditionalFilter.enums.ProductAttribute;
import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.attribute_operator.IAttributeOperatorStrategy;

public interface IProductAttributeFilter {
    boolean isAttributeApplicable(ProductAttribute attribute);
    boolean evaluateFilter(Product product, FilterCondition condition);
    IAttributeOperatorStrategy getOperatorStrategy();
}
