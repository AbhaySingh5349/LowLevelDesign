package Questions.RuleExpressionSystem.Sol3.enums;

import Questions.RuleExpressionSystem.Sol3.strategy.data_type.IDataTypeStrategy;
import Questions.RuleExpressionSystem.Sol3.strategy.data_type.NumberDataTypeStrategy;
import Questions.RuleExpressionSystem.Sol3.strategy.data_type.StringDataTypeStrategy;

public enum DataType {
    STRING(new StringDataTypeStrategy()),
    NUMBER(new NumberDataTypeStrategy());

    private final IDataTypeStrategy strategy;

    DataType(IDataTypeStrategy strategy) {
        this.strategy = strategy;
    }

    public IDataTypeStrategy getStrategy() {
        return strategy;
    }
}
