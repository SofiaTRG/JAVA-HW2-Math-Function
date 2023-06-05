/**
 * Represents the negation of a function.
 */
public class Negation extends Function {
    private final Function function;

    /**
     * Constructs a Negation object with the specified function.
     * @param function  the function to be negated
     */
    public Negation(Function function) {
        this.function = function;
    }

    /**
     * Calculates the negation of the value of the function at the given x.
     * @param x  the value of x to evaluate the negation
     * @return the negation of the value of the function
     */
    @Override
    public double valueAt(double x) {
        return -function.valueAt(x);
    }

    /**
     * Returns the string representation of the negation.
     * @return the string representation of the negation
     */
    @Override
    public String toString() {
        return "(-" + function.toString() + ")";
    }

    /**
     * Returns the derivative of the negation.
     * The derivative of a negation is obtained by taking the derivative of the inner function and negating it.
     * @return the derivative of the negation as a Function object
     */
    @Override
    public Function derivative() {
        return new Negation(function.derivative());
    }
}
