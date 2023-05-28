public class MultiSum extends Function {
    private Function[] functions;

    public MultiSum(Function... functions) {
        this.functions = functions;
    }

    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Function function : functions) {
            sb.append(function.toString());
        }
        return sb.toString();
    }

    @Override
    public String derivative() {
        StringBuilder sb = new StringBuilder();
        for (Function function : functions) {
            sb.append(function.derivative());
        }
        return sb.toString();
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.bisectionMethod(a, b, epsilon);
        }
        return sum;
    }

    @Override
    public double newtonRaphsonMethod(double a, double b) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.newtonRaphsonMethod(a, b);
        }
        return sum;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.newtonRaphsonMethod(a);
        }
        return sum;
    }

    @Override
    public String taylorPolynomial(int n) {
        StringBuilder sb = new StringBuilder();
        for (Function function : functions) {
            sb.append(function.taylorPolynomial(n));
        }
        return sb.toString();
    }
}

