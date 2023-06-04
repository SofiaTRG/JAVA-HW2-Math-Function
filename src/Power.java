public class Power extends Function {

    private final Function function;
    private final int exponent;

    public Power(Function function, int exponent) {
        this.function = function;
        this.exponent = exponent;
    }


    @Override
    public double valueAt(double x) {
        return Math.pow(function.valueAt(x), exponent);
    }

    @Override
    public String toString() {
        return "(" + function.toString() + ")^" + exponent;
    }

    @Override
    public Function derivative() {
        Function functionDerivative = function.derivative();
        Function powerDerivative = new Power(function, exponent - 1);
        Function exponentConstant = new Constant(exponent);

        // Apply the chain rule to calculate the derivative of the power term
        Function powerTermDerivative = new MultiProduct(exponentConstant, powerDerivative, functionDerivative);

        // Apply the product rule to calculate the derivative of the entire Power function
        return new Product(powerTermDerivative, functionDerivative);
    }

}

