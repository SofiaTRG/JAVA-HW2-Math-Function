/**
 * the constant functions is f(x)=ax+b
 */
public final class Constant extends Function {
    static double a;
    static double b;

    public Constant(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + "x" + b;
    }

    @Override
    public String derivative() {
        return String.valueOf(a);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return super.bisectionMethod(a, b, epsilon);
    }

    @Override
    public double newtonRaphsonMethod(double num_1) {
        return super.newtonRaphsonMethod(num_1);
    }

    @Override
    public double newtonRaphsonMethod(double num_1, double num_2) {
        return super.newtonRaphsonMethod(num_1, num_2);
    }

    @Override
    public String taylorPolynomial(int n) {
        return super.taylorPolynomial(n);
    }
}