public class Quotient extends Function {
    private final Function function1;
    private final Function function2;

    public Quotient(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        double value2 = function2.valueAt(x);
        if (value2 == 0) {
            throw new ArithmeticException("Division by zero error!");
        }
        return function1.valueAt(x) / value2;
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + " / " + function2.toString() + ")";
    }

    @Override
    public Function derivative() {
        Function numerator = new Sum(
                new Product(function1.derivative(), function2),
                new Negation(new Product(function1, function2.derivative()))
        );
        Function denominator = new Power(function2, 2);
        return new Quotient(numerator, denominator);
    }
}
