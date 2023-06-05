/**
 * the power class: function^(exponent)
 */
public class Power extends Function {

    private final Function function;
    private final int exponent;

    /**
     * the constructor
     * @param function the base function
     * @param exponent the exponent
     */
    public Power(Function function, int exponent) {
        this.function = function;
        this.exponent = exponent;
    }

    /**
     * calculates the value of the function raised to the specified exponent at the given x.
     * @param x the value of x to evaluate the function
     * @return the value of the function^(exponent)
     */
    @Override
    public double valueAt(double x) {
        return Math.pow(function.valueAt(x), exponent);
    }

    /**
     * returns the function as string
     * @return the function as string
     */
    @Override
    public String toString() {
        return "(" + function.toString() + "^" + exponent + ")";
    }

    /**
     * calculates the derivative of power: (exponent)*function(x)^(exponent-1)*function'(x)
     * @return the derivative
     */
    @Override
    public Function derivative() {
        /** if exponent is 0 the derivative is 0, if exponent is 1 the derivative is function'(x) */
        if (exponent == 0) {
            return new Constant(0);
        } if (exponent == 1) {
            return function.derivative();
        }
        Function functionDerivative = function.derivative();
        Function powerDerivative = new Power(function, exponent - 1);
        Function exponentConstant = new Constant(exponent);
        /** chain rule to calculate the derivative of the power term */
        return new MultiProduct(exponentConstant, powerDerivative, functionDerivative);

    }

}

