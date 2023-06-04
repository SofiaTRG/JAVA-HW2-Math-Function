public class Polynomial extends Function{

    private final double[] coefficients;

    //hey
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }
    @Override
    public double valueAt(double x) {
        double result = 0.0;
        for (int i=0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x,i);
        }
        return result;
    }

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
            return "0";
        } else {
            return "(" + polynomial + ")";
        }
    }

    @Override
    public Function derivative() {
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
