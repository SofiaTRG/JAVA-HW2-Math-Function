public abstract class Function {

    public Object function;
    public Function(Function function) {
        this.function = Constant.function;
    }

    public double valueAt(double x) {
        return 0;
    }

    public String toStrong() {
        return function.toString();
    }

    public String deriavative() {
        return function.toString();
    }

    public double bisectionMethod(double a, double b, double epsilon) {
        return 0.0;
    }

    public double newtonRaphsonMethod(double a, double b) {
        return 0.0;
    }

    public double newtonRaphsonMethod(double a) {
        return 0.0;
    }

    public String taylorPolynomial(int n) {
        return toString();
    }
}
