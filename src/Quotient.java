public class Quotient extends Function {
    Function function1;
    Function function2;

    public Quotient(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x)/function2.valueAt(x);
    }

    @Override
    public String toString() {
        return function1.toString() + function2.toString();
    }

    //NEED TO USE THE PRODUCT FUNCTION???
    @Override
    public String derivative() {
        return function1.derivative();
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) { return 0; }

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
        return null;
    }
}
