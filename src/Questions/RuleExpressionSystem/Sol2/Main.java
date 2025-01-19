package Questions.RuleExpressionSystem.Sol2;

import Questions.RuleExpressionSystem.Sol2.enums.DataType;
import Questions.RuleExpressionSystem.Sol2.enums.Operator;
import Questions.RuleExpressionSystem.Sol2.strategy.ConditionExpression;
import Questions.RuleExpressionSystem.Sol2.strategy.OrExpression;

public class Main {
    public static void main(String[] args) {
        try {
            // Example 1: Valid string rule
            ConditionExpression stringCondition = new ConditionExpression(
                    "name", Operator.CONTAINS, "John", DataType.STRING
            );

            // Example 2: Valid number rule
            ConditionExpression numberCondition = new ConditionExpression(
                    "age", Operator.GREATER_THAN, 30, DataType.NUMBER
            );

//             Example 3: Invalid combination (throws exception)
//             Operator "contains" is invalid for NUMBER type

//             ConditionExpression invalidCondition = new ConditionExpression(
//                 "age", Operator.CONTAINS, 30, DataType.NUMBER
//             );

            OrExpression orExpression = new OrExpression(stringCondition, numberCondition);

            System.out.println("Constructed Rule:");
            System.out.println(orExpression.buildRule());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

/*
{
  "any": [
    {
      "field": "name",
      "operator": "contains",
      "value": "John",
      "dataType": "STRING"
    },
    {
      "field": "age",
      "operator": ">",
      "value": "30",
      "dataType": "NUMBER"
    }
  ]
}
*/
