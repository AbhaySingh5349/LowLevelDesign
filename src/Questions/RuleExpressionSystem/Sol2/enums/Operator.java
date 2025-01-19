package Questions.RuleExpressionSystem.Sol2.enums;

public enum Operator {
    EQUALS("==", DataType.STRING, DataType.NUMBER),
    NOT_EQUALS("!=", DataType.STRING, DataType.NUMBER),
    GREATER_THAN(">", DataType.NUMBER),
    LESS_THAN("<", DataType.NUMBER),
    GREATER_THAN_OR_EQUALS(">=", DataType.NUMBER),
    LESS_THAN_OR_EQUALS("<=", DataType.NUMBER),
    CONTAINS("contains", DataType.STRING),
    STARTS_WITH("startsWith", DataType.STRING),
    ENDS_WITH("endsWith", DataType.STRING);

    private final String symbol;
    private final DataType[] validTypes;

    Operator(String symbol, DataType... validTypes) {
        this.symbol = symbol;
        this.validTypes = validTypes;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isValidForType(DataType dataType) {
        for (DataType validType : validTypes) {
            if (validType == dataType) {
                return true;
            }
        }
        return false;
    }
}
