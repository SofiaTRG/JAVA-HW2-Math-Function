/**
 * the constant functions is f(x)=a
 */
public final class Constant extends Function {
    static double[] a = new double[1];

    @Override
    public double valueAt(double x) {
        return a[0];
    }

    public Constant(double a) {
        this.a[0] = a;
    }

    @Override
    public String toString() {
        return a[0] + "x";
    }

    /**
     * the derivative of constant function which is 0
     * @return f'(x) = 0
     */
    @Override
    public String derivative() {
        return String.valueOf(0);
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
     * @param n the grade of taylor polynomial
     * @return taylor polynomial
     */
    @Override
    public String taylorPolynomial(int n) {
        return String.valueOf(a[0]);
    }
}