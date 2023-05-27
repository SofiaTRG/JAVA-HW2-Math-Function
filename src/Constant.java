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

    /**
     * the derivative of constant function which is a
     * @return f'(x) = a
     */
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

    /**
     * returns taylor polynomial around x=n
     * @param n
     * @return taylor polynomial
     */
    @Override
    public String taylorPolynomial(int n) {
        return getValue(n) + a + "x" ;
    }

    /**
     * get the f(x) by given x
     * @param x value of x, we want to find f(x)
     * @return f(x)
     */
    public double getValue(double x) {
        return a*x+b;
    }
}