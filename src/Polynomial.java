/**
 * the class of polynomial, it has the array of its coefficients in ascending order
 */
public class Polynomial extends Function{

    private final double[] coefficients;

    /**
     * constructor
     * @param coefficients the array of values of coefficients of the function in ascending order of powers of x
     */
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * give the value of f(x) by the given x
     * @param x the x we wnt to find it's f(x) value
     * @return f(x)
     */
    @Override
    public double valueAt(double x) {
        double result = 0.0;
        for (int i=0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x,i);
        }
        return result;
    }

    /**
     * makes a string of the function. go for every index and check if negative/positive. put -/+ as a string together
     * with the absolute value of coefficient in the place of the index
     * @return returns the string
     */
    @Override
    public String toString() {
        StringBuilder polynomial = new StringBuilder();
        int highestPower = coefficients.length - 1;

        for (int i = 0; i <= highestPower; i++) {
            double coefficient = coefficients[i];
            boolean isZero = coefficient == 0;
            boolean isOne = Math.abs(coefficient) == 1;
            boolean isInteger = Math.floor(coefficient) == coefficient;

            if (isZero) {
                continue;
            }

            if (polynomial.length() > 0) {
                if (coefficient > 0) {
                    polynomial.append(" + ");
                } else {
                    polynomial.append(" - ");
                    coefficient = Math.abs(coefficient);
                }
            } else {
                if (coefficient < 0) {
                    polynomial.append("-");
                    coefficient = Math.abs(coefficient);
                }
            }

            if (isOne && i > 0) {
                polynomial.append("x");
            } else {
                if (isInteger) {
                    polynomial.append((int) coefficient);
                } else {
                    polynomial.append(coefficient);
                }
                if (i > 0) {
                    polynomial.append("x");
                }
            }

            if (i > 1) {
                polynomial.append("^").append(i);
            }
        }

        if (polynomial.length() == 0) {
            return "(0)";
        } else {
            return "(" + polynomial + ")";
        }
    }

    /**
     * returns the derivative of the polynomial function. for every value in polynomial the power of x is reduced by 1
     * and the coefficient is multiplied by the original power.
     * @return the derivative of the polynomial as a new polynomial object
     */
    @Override
    public Function derivative() {
        /** check if the value is 0 */
        int lengthDerivative = coefficients.length;
        if (lengthDerivative == 0) {
            return new Constant(0);
        }
        double[] derivativePolynomial = new double[lengthDerivative - 1];

        for (int i = 1; i < lengthDerivative; i++) {
            derivativePolynomial[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(derivativePolynomial);
    }
}
