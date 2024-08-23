package CompositeDesignPattern.ArithmeticExpression;

/*

                        MultiplyExpression (mul)
                        /                     \
                SumExpression (sum2)        NumericExpression (d = 4)
                      /          \
NumericExpression (c = 3)   SumExpression (sum1)
                                 /           \
                    NumericExpression (a = 1)  NumericExpression (b = 2)

*/

public class Main {
    public static void main(String[] args) {
        NumericExpression a = new NumericExpression(1);
        NumericExpression b = new NumericExpression(2);
        NumericExpression c = new NumericExpression(3);
        NumericExpression d = new NumericExpression(4);

        SumExpression sum1 = new SumExpression(a, b);
        SumExpression sum2 = new SumExpression(c, sum1);
        MultiplyExpression mul = new MultiplyExpression(sum2, d);

        System.out.println("sum1: " + sum1.solve());
        System.out.println("sum2: " + sum2.solve());
        System.out.println("mul: " + mul.solve());
    }
}
