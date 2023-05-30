
// NEED THE POLY FUNCTION TO CONTINUE
public class Sum extends Function {
    Function function1;
    Function function2;

    public Sum(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) + function2.valueAt(x);
    }

    @Override
    public String toString() {
        return function1.toString() + function2.toString();
    }

    @Override
    public Function derivative() {
        return new Sum(function1.derivative() , function2.derivative());
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return function1.bisectionMethod(a, b, epsilon) + function2.bisectionMethod(a, b, epsilon);
    }

    @Override
    public double newtonRaphsonMethod(double a, double b) {
        return function1.newtonRaphsonMethod(a, b) + function2.newtonRaphsonMethod(a, b);
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return function1.newtonRaphsonMethod(a) + function2.newtonRaphsonMethod(a);
    }

    @Override
    public String taylorPolynomial(int n) {
        return function1.taylorPolynomial(n) + function2.taylorPolynomial(n);
    }
}
