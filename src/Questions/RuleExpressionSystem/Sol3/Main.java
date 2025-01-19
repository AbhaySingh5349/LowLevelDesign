package Questions.RuleExpressionSystem.Sol3;

import Questions.RuleExpressionSystem.Sol3.enums.DataType;
import Questions.RuleExpressionSystem.Sol3.enums.Operator;
import Questions.RuleExpressionSystem.Sol3.strategy.expression.AndExpression;
import Questions.RuleExpressionSystem.Sol3.strategy.expression.ConditionExpression;
import Questions.RuleExpressionSystem.Sol3.strategy.expression.NotExpression;
import Questions.RuleExpressionSystem.Sol3.strategy.expression.OrExpression;

public class Main {
    public static void main(String[] args) {
        try {
            // Simple Valid rules
//            ConditionExpression stringCondition = new ConditionExpression(
//                    "name", Operator.CONTAINS, "John", DataType.STRING
//            );
//
//            ConditionExpression numberCondition = new ConditionExpression(
//                    "age", Operator.GREATER_THAN, 30, DataType.NUMBER
//            );
//
//            OrExpression orExpression = new OrExpression(stringCondition, numberCondition);
//
//            System.out.println("Constructed Rule:");
//            System.out.println(orExpression.buildRule());

            // Complex rule
            ConditionExpression condition1 = new ConditionExpression(
                    "field1", Operator.CONTAINS, "John", DataType.STRING
            );

            ConditionExpression condition2 = new ConditionExpression(
                    "field2", Operator.GREATER_THAN, 20, DataType.NUMBER
            );

            ConditionExpression condition3 = new ConditionExpression(
                    "field3", Operator.LESS_THAN, 50, DataType.NUMBER
            );

            // NOT condition1
            NotExpression notCondition1 = new NotExpression(condition1);

            // AND condition2 and condition3
            AndExpression andCondition = new AndExpression(condition2, condition3);

            // OR NOT(condition1) with AND(condition2, condition3)
            OrExpression orExpression = new OrExpression(notCondition1, andCondition);

            System.out.println("Complex Rule:");
            System.out.println(orExpression.buildRule());

            // Invalid rule: contains is not valid for NUMBER
            // ConditionExpression invalidCondition = new ConditionExpression(
            //     "age", Operator.CONTAINS, 30, DataType.NUMBER
            // );
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
