/**
 * Represents a multi-sum of functions.
 */
public class MultiSum extends Function {

    private final Function[] functions;

    /**
     * Constructs a MultiSum object with the specified functions.
     * The MultiSum requires at least two functions to work correctly.
     * @param function1  the first function of the multi-sum
     * @param functions  the other functions of the multi-sum
     */
    public MultiSum(Function function1, Function... functions) {
        this.functions = new Function[functions.length + 1];
        this.functions[0] = function1;
        for (int i = 0; i < functions.length; i++) {
            this.functions[i + 1] = functions[i];
        }
    }

    /**
     * Calculates the sum of all the values of the functions in the array at the given x.
     * @param x  the value of x to evaluate the multi-sum
     * @return the value of the multi-sum
     */
    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }

    /**
     * Returns the string representation of the multi-sum.
     * @return the string representation of the multi-sum
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i < functions.length - 1) {
                sb.append(" + ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Returns the derivative of the multi-sum.
     * The derivative of a multi-sum is obtained by taking the derivative of each function
     * and forming a new multi-sum with the derivative functions.
     * @return the derivative of the multi-sum as a Function object
     */
    @Override
    public Function derivative() {
        int lengthFunctions = functions.length;
        Function[] derivativeMulti = new Function[lengthFunctions];

        int i = 0;
        for (Function function : functions) {
            derivativeMulti[i] = function.derivative();
            i++;
        }

        Function[] newDerivatives = new Function[functions.length - 1];
        for (int j = 1; j < functions.length; j++) {
            newDerivatives[j - 1] = derivativeMulti[j];
        }

        return new MultiSum(derivativeMulti[0], newDerivatives);
    }
}
