/**
 * the constant functions is f(x)=a. has only one value inside, "a" as double.
 */
public final class Constant extends Function {
    private final double a;

    @Override
    public double valueAt(double x) {
        return a;
    }


    public Constant(double a) {
        this.a = a;
    }

    @Override
    public String toString() {
        if (a == (int) a) {
            return "(" + (int) a + ")";
        } else {
            return "(" + a + ")";
        }
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