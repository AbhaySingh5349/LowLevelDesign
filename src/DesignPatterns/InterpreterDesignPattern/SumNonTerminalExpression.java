package DesignPatterns.InterpreterDesignPattern;

public class SumNonTerminalExpression implements AbstractExpression{
    AbstractExpression leftExpression;
    AbstractExpression rightExpression;

    public SumNonTerminalExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Integer interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}
