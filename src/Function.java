public abstract class Function {

    public double valueAt(double x) {
        return 0;
    }

    @Override
    public String toString() {
        return "toString";
    }

    public String derivative() {
        // Implement the logic to compute and return the derivative of the function
        return "Derivative";
    }

    public double bisectionMethod(double a, double b, double epsilon) {
        // Implement the Bisection Method algorithm
        return 0.0;
    }

    public double newtonRaphsonMethod(double a, double b) {
        // Implement the Newton-Raphson Method algorithm
        return 0.0;
    }

    public double newtonRaphsonMethod(double a) {
        // Implement the Newton-Raphson Method algorithm
        return 0.0;
    }

    public String taylorPolynomial(int n) {
        // Implement the logic to compute and return the Taylor Polynomial of degree n
        return "Taylor Polynomial";
    }
}
