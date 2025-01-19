package Questions.RuleExpressionSystem.Sol1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeExpression implements Expression{
    private String type; // "all" for AND, "any" for OR
    private List<Expression> expressions;

    public CompositeExpression(String type) {
        this.type = type;
        this.expressions = new ArrayList<>();
    }

    public void addExpression(Expression expression) {
        expressions.add(expression);
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        List<Object> childMaps = new ArrayList<>();
        for (Expression expr : expressions) {
            childMaps.add(expr.toMap());
        }
        map.put(type, childMaps);
        return map;
    }
}
