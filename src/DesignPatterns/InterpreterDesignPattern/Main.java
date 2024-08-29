package DesignPatterns.InterpreterDesignPattern;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        context.put("d", 4);

        AbstractExpression add1 = new SumNonTerminalExpression(new NumberTerminalExpression("a"), new NumberTerminalExpression("b"));
        AbstractExpression add2 = new SumNonTerminalExpression(new NumberTerminalExpression("c"), new NumberTerminalExpression("d"));
        AbstractExpression mul = new MultiplyNonTerminalExpression(add1, add2);

        System.out.println("add1: " + add1.interpret(context) + " , add2: " + add2.interpret(context) + " -> mul: " + mul.interpret(context));
    }
}
