package Questions.RuleExpressionSystem.Sol1;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Leaf nodes
        LeafExpression conditionA = new LeafExpression("field_A", ">", 10);
        LeafExpression conditionB = new LeafExpression("field_B", "<=", 20);
        LeafExpression conditionC = new LeafExpression("field_C", "==", "active");
        LeafExpression conditionD = new LeafExpression("field_D", "!=", "inactive");

        // Composite nodes
        CompositeExpression orGroup1 = new CompositeExpression("any");
        orGroup1.addExpression(conditionA);
        orGroup1.addExpression(conditionB);

        CompositeExpression orGroup2 = new CompositeExpression("any");
        orGroup2.addExpression(conditionC);
        orGroup2.addExpression(conditionD);

        CompositeExpression andGroup = new CompositeExpression("all");
        andGroup.addExpression(orGroup1);
        andGroup.addExpression(orGroup2);

        // Convert to JSON-compatible structure
        Map<String, Object> ruleMap = andGroup.toMap();

        // Print the result
        System.out.println(ruleMap);
    }
}
