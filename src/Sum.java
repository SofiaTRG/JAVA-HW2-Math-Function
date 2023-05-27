import static java.lang.Math.max;
import static java.lang.Math.min;

// NEED THE POLY FUNCTION TO CONTINUE
public class Sum extends Function {
    double[] function;

    public Sum(double[] function1, double[] function2) {
        int sum_length = max(function1.length, function2.length);
        double[] max_function = new double[sum_length];

        if (function1.length > function2.length) {
            max_function = function1;
        } else {
            max_function = function2;
        }

        int small_length = min(function1.length, function2.length);

        double[] sum_function = new double[sum_length];

        for (int i = 0; i < sum_length; i++) {
            if (i < small_length) {
                sum_function[i] = function1[i] + function2[i];
            } else {
                sum_function[i] = max_function[i];
            }
        }
    }

    @Override
    public double valueAt(double x) {
        return super.valueAt(x);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String derivative() {
        double[] derivative_function = new double[function.length];
        for (int i = 0; i < function.length; i++) {
            derivative_function[i] = (i*function[i]);
        }
        return derivative_function;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return super.bisectionMethod(a, b, epsilon);
    }

    @Override
    public double newtonRaphsonMethod(double a, double b) {
        return super.newtonRaphsonMethod(a, b);
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return super.newtonRaphsonMethod(a);
    }

    @Override
    public String taylorPolynomial(int n) {
        return super.taylorPolynomial(n);
    }
}
