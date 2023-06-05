/**
 * Represents a multi-product of functions.
 */
public class MultiProduct extends Function {
    private final Function[] functions;

    /**
     * Constructs a MultiProduct object with the specified functions.
     * @param function1  the first function of the multi-product
     * @param functions  the other functions of the multi-product
     */
    public MultiProduct(Function function1, Function... functions) {
        this.functions = new Function[functions.length + 1];
        this.functions[0] = function1;

        for (int i = 0; i < functions.length; i++) {
            this.functions[i + 1] = functions[i];
        }
    }

    /**
     * Calculates the product of all the values of the functions in the array at the given x.
     * @param x  the value of x to evaluate the multi-product
     * @return the value of the multi-product
     */
    @Override
    public double valueAt(double x) {
        double result = 1.0;
        for (Function function : functions) {
            result *= function.valueAt(x);
        }
        return result;
    }

    /**
     * Returns the string representation of the multi-product.
     * @return the string representation of the multi-product
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i < functions.length - 1) {
                sb.append(" * ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Returns the derivative of the multi-product.
     * The derivative of a multi-product is obtained by applying the product rule
     * to calculate the derivative of each function and forming a new multi-sum with the derivative functions.
     * @return the derivative of the multi-product as a Function object
     */
    @Override
    public Function derivative() {
        Function[] derivatives = new Function[functions.length];

        for (int i = 0; i < functions.length; i++) {
            Function[] otherFunctions = new Function[functions.length - 1];
            int index = 0;

            for (int j = 0; j < functions.length; j++) {
                if (j != i) {
                    otherFunctions[index] = functions[j];
                    index++;
                }
            }
            derivatives[i] = new MultiProduct(functions[i].derivative(), otherFunctions);
        }

        Function[] newDerivatives = new Function[functions.length - 1];
        for (int i = 1; i < functions.length; i++) {
            newDerivatives[i - 1] = derivatives[i];
        }
        return new MultiSum(derivatives[0], newDerivatives);
    }
}
