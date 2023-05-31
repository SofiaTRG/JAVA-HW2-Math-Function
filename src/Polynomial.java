public class Polynomial extends Function{

    private final double[] coefficients;

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

        boolean isZero;
        boolean isInteger;
        boolean isOne;
        boolean isNegative;
        StringBuilder polynomial = new StringBuilder();


        if(coefficients[0] != 0 && coefficients.length >= 1) {
            isNegative = coefficients[0] < 0 ? true : false;
            isInteger = Math.floor(coefficients[0]) == coefficients[0] ? true : false;
            if(isNegative) {
                polynomial.append("-");
            }
            if(isInteger) {
                polynomial.append((int)coefficients[0]);
            } else
                polynomial.append(coefficients[0]);
        }


        if (coefficients[1] != 0&& coefficients.length >= 2) {

            isNegative = coefficients[1] < 0 ? true : false;
            isInteger = Math.floor(coefficients[1]) == coefficients[1] ? true : false;
            isOne = Math.abs(coefficients[1]) == 1 ? true : false;

            if (isNegative) {
                polynomial.append("-");
            } else {
                polynomial.append("+");
            }

            if (isOne) {
                polynomial.append("x");
            }

            if(isInteger && !isOne) {
                polynomial.append((int)coefficients[1] + "x");
            }

            if(!isInteger) {
                polynomial.append(coefficients[1] + "x");
            }

    }


        for(int i=2; i<coefficients.length; i++) {

            isNegative = coefficients[i] < 0 ? true : false;
            isInteger = Math.floor(coefficients[i]) == coefficients[i] ? true : false;
            isOne = Math.abs(coefficients[i]) == 1 ? true : false;
            isZero = coefficients[i] == 0 ? true : false;

            if(isZero) {
                continue;
            }

            if (isNegative) {
                polynomial.append("-");
            } else {
                polynomial.append("+");
            }

            if (isOne) {
                polynomial.append("x^" + i);
            }

            if(isInteger && !isOne) {
                polynomial.append((int)coefficients[i] + "x^" + i);
            }

            if(!isInteger) {
                polynomial.append(coefficients[i] + "x^" + i);
            }
        }
        //

        if(polynomial.length() == 0)
            return "(0)";
        else
            return "(" + polynomial + ")";
    }

    @Override
    public Function derivative() {
        int lengthDerivative = coefficients.length;
        Double[] derivativePolynomial = new Double[lengthDerivative - 1];

        for (int i = 1; i < lengthDerivative; i++) {
            derivativePolynomial[i - 1] = coefficients[i] * i;
        }

        return new Polynomial(derivativePolynomial);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        double c = (a + b)/2;
        while ((b-a) > epsilon) {
            c = (a + b)/2;
            if (valueAt(a)*valueAt(c) > 0) {
                a = c;
            } else {
                b = c;
            }
        }
        return c;
    }


    @Override
    public double newtonRaphsonMethod(double a) {

    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {

    }

    @Override
    public Function taylorPolynomial(int n) {
        StringBuilder taylor = new StringBuilder();

        // Add f(x=0)
        taylor.append(valueAt(0));

        Function currentDerivative = this;
        double currentCoefficient;

        for (int i = 1; i <= n; i++) {
            currentDerivative = currentDerivative.derivative();
            currentCoefficient = currentDerivative.valueAt(0) / factorial(i);

            if (currentCoefficient != 0) {
                taylor.append(" + " + currentCoefficient);

                if (i > 1) {
                    taylor.append("x^" + i);
                } else {
                    taylor.append("x");
                }
            }
        }

        return taylor;
    }

    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
