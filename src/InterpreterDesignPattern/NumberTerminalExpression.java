package InterpreterDesignPattern;

public class NumberTerminalExpression implements AbstractExpression{
    String key;

    public NumberTerminalExpression(String key) {
        this.key = key;
    }

    @Override
    public Integer interpret(Context context) {
        return context.get(key);
    }
}
