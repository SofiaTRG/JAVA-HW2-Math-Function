public class Quotient extends Function {
    Function function1;
    Function function2;

    public Quotient(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    // IF FUNCTION2 = 0
    @Override
    public double valueAt(double x) {
        return function1.valueAt(x)/function2.valueAt(x);
    }

    //?????????????????????????????????????
    @Override
    public String toString() {
        return function1.toString() + function2.toString();
    }

    //NEED TO USE THE PRODUCT FUNCTION???
    @Override
    public Function derivative() {
        return new Quotient((Sum((Product(function1.derivative(), function2)),
                Negation(Product(function1, function2.derivative())))), Power(function2), 2);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a, double b) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return 0;
    }

    @Override
    public String taylorPolynomial(int n) {
        StringBuilder taylor = new StringBuilder();

        // Evaluate the Taylor polynomials for the numerator and denominator
        String numeratorTaylor = function1.taylorPolynomial(n);
        String denominatorTaylor = function2.taylorPolynomial(n);

        // Combine the terms using the quotient rule
        for (int i = 0; i <= n; i++) {
            String numeratorTerm = termWithExponent(numeratorTaylor, i);
            String denominatorTerm = termWithExponent(denominatorTaylor, i);

            if (denominatorTerm.equals("0")) {
                // Handle the division by zero case separately
                taylor.append("Undefined");
            } else {
                if (i == 0) {
                    // Handle the constant term separately
                    taylor.append(numeratorTerm).append(" / ").append(denominatorTerm);
                } else {
                    taylor.append(" + ").append("(").append(numeratorTerm).append(" / ").append(denominatorTerm).append(")");
                }
            }
        }

        return taylor.toString();
    }

    private String termWithExponent(String term, int exponent) {
        if (exponent == 0) {
            return term;
        } else if (exponent == 1) {
            return term + " * x";
        } else {
            return term + " * x^" + exponent;
        }
    }

}
