/**
 * Represents the difference between two functions.
 */
public class Difference extends Function {
    private final Function function1;
    private final Function function2;

    /**
     * Constructs a Difference object with the specified functions.
     * @param function1  the first function
     * @param function2  the second function
     */
    public Difference(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    /**
     * Calculates the difference between the values of the two functions at the given x.
     * @param x  the value of x to evaluate the difference
     * @return the difference between the values of the two functions
     */
    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) - function2.valueAt(x);
    }

    /**
     * Returns the string representation of the difference.
     * @return the string representation of the difference
     */
    @Override
    public String toString() {
        return "(" + function1.toString() + " - " + function2.toString() + ")";
    }

    /**
     * Returns the derivative of the difference.
     * The derivative of a difference is obtained by taking the derivatives of the two functions separately.
     * @return the derivative of the difference as a Function object
     */
    @Override
    public Function derivative() {
        return new Difference(function1.derivative(), function2.derivative());
    }
}
