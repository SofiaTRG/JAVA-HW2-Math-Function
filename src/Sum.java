/**
 * Represents the sum of two functions.
 */
public class Sum extends Function {
    private final Function function1;
    private final Function function2;

    /**
     * Constructs a Sum object with the specified functions to be summed.
     * @param function1  the first function to be summed
     * @param function2  the second function to be summed
     */
    public Sum(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    /**
     * Calculates the value of the sum at the given x.
     * @param x  the value of x to evaluate the sum
     * @return the value of the sum at the given x
     */
    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) + function2.valueAt(x);
    }

    /**
     * Returns the string representation of the sum.
     * @return the string representation of the sum
     */
    @Override
    public String toString() {
        return "(" + function1.toString() + " + " + function2.toString() + ")";
    }

    /**
     * Returns the derivative of the sum.
     * The derivative of a sum is obtained by taking the derivatives of each function separately.
     * @return the derivative of the sum as a Function object
     */
    @Override
    public Function derivative() {
        return new Sum(function1.derivative(), function2.derivative());
    }
}
