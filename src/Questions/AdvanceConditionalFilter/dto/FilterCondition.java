package Questions.AdvanceConditionalFilter.dto;

import Questions.AdvanceConditionalFilter.enums.Operator;
import Questions.AdvanceConditionalFilter.enums.ProductAttribute;

public class FilterCondition {
    private final ProductAttribute attribute;
    private final Operator operator;
    private final Object value;

    public FilterCondition(ProductAttribute attribute, Operator operator, Object value) {
        this.attribute = attribute;
        this.operator = operator;
        this.value = value;
    }

    public ProductAttribute getAttribute() {
        return attribute;
    }

    public Operator getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }
}
