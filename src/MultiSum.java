public class MultiSum extends Function {
    private final Function[] functions;

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
        sb.append("(");
        for (Function function : functions) {
            sb.append(function.toString());
            sb.append(" + ");
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public Function derivative() {
        int lengthFunctions = functions.length;
        Function[] derivativeMulti = new Function[lengthFunctions];

        int i = 0;
        for (Function function : functions) {
            derivativeMulti[i] = function.derivative();
            i++;
        }
        return new MultiSum(derivativeMulti);
    }
}

