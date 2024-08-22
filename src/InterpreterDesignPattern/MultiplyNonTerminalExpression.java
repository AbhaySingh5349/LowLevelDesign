package InterpreterDesignPattern;

public class MultiplyNonTerminalExpression implements AbstractExpression{
    AbstractExpression leftExpression;
    AbstractExpression rightExpression;

    public MultiplyNonTerminalExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Integer interpret(Context context) {
        return leftExpression.interpret(context) * rightExpression.interpret(context);
    }
}
