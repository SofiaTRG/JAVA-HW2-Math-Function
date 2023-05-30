/**
 * the constant functions is f(x)=a
 */
public final class Constant extends Function {
    static double a;

    @Override
    public double valueAt(double x) {
        return a;
    }

    public Constant(double a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.valueOf((a));
    }

    /**
     * the derivative of constant function which is 0
     * @return f'(x) = 0
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) { return Constant.a; }

    @Override
    public double newtonRaphsonMethod(double num_1) {
        return a;
    }

    @Override
    public double newtonRaphsonMethod(double num_1, double num_2) { return a; }

    @Override
    public String taylorPolynomial(int n) {
        return String.valueOf(a);
    }
}