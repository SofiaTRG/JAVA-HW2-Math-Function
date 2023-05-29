public class Negation extends Function{
    Function function;

    public Negation(Function function) {
        this.function = function;
    }
    @Override
    public double valueAt(double x) {
        return -function.valueAt(x);
    }

    @Override
    public String toString() {
        return "-(" + function.toString() + ")";
    }

    @Override
    public String derivative() {
        return "-(" + function.derivative() + ")";
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return -bisectionMethod(a, b, epsilon);
    }

    @Override
    public double newtonRaphsonMethod(double a, double b) {
        return -function.newtonRaphsonMethod(a, b);
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return -function.newtonRaphsonMethod(a);
    }

    @Override
    public String taylorPolynomial(int n) {
        return null;
    }
}
