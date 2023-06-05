public class MultiSum extends Function {

    private final Function[] functions;

    public MultiSum(Function function1, Function... functions) {

        this.functions = new Function[functions.length + 1];
        this.functions[0] = function1;

        for (int i=0; i < functions.length; i++) {
            this.functions [i+1] = functions[i];
        }
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
        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i < functions.length - 1) {
                sb.append(" + ");
            }
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

        Function[] newDerivatives = new Function[functions.length-1];
        for (int j=1; j< functions.length; j++) {
            newDerivatives[j-1] = derivativeMulti[j];
        }

        return new MultiSum(derivativeMulti[0], newDerivatives);
    }
}