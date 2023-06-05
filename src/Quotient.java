/**
 * Represents the quotient of two functions.
 */
public class Quotient extends Function {
    private final Function function1;
    private final Function function2;

    /**
     * Constructs a Quotient object with the specified numerator and denominator functions.
     * @param function1  the numerator function
     * @param function2  the denominator function
     */
    public Quotient(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    /**
     * Calculates the value of the quotient at the given x.
     * @param x  the value of x to evaluate the quotient
     * @return the value of the quotient at the given x
     * @throws ArithmeticException if the denominator function evaluates to zero
     */
    @Override
    public double valueAt(double x) {
        double value2 = function2.valueAt(x);
        if (value2 == 0) {
            throw new ArithmeticException("Division by zero error!");
        }
        return function1.valueAt(x) / value2;
    }

    /**
     * Returns the string representation of the quotient.
     * @return the string representation of the quotient
     */
    @Override
    public String toString() {
        return "(" + function1.toString() + " / " + function2.toString() + ")";
    }

    /**
     * Returns the derivative of the quotient.
     * The derivative of a quotient is obtained using the quotient rule.
     * @return the derivative of the quotient as a Function object
     */
    @Override
    public Function derivative() {
        Function numerator = new Difference(new Product(function1.derivative(), function2),
                new Product(function2.derivative(), function1));
        Function denominator = new Power(function2, 2);
        return new Quotient(numerator, denominator);
    }
}
