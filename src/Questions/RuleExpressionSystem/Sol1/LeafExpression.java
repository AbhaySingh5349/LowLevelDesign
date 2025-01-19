package Questions.RuleExpressionSystem.Sol1;

import java.util.HashMap;
import java.util.Map;

public class LeafExpression implements Expression{
    private String field;
    private String operator;
    private Object value;

    public LeafExpression(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("field", field);
        map.put("operator", operator);
        map.put("value", value);
        return map;
    }
}
