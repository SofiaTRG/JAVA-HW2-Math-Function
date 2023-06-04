public class MultiProduct extends Function {
    private final Function[] functions;

    public MultiProduct(Function... functions) {
        this.functions = functions;
    }

    @Override
    public double valueAt(double x) {
        double result = 1.0;
        for (Function function : functions) {
            result *= function.valueAt(x);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i < functions.length - 1) {
                sb.append(" * ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public Function derivative() {
        Function[] derivatives = new Function[functions.length];
        for (int i = 0; i < functions.length; i++) {
            derivatives[i] = functions[i].derivative();
        }
        return new MultiProduct(derivatives);
    }
}
