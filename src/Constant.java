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
}