public class MultiProduct extends Function {
    private final Function[] functions;

    public MultiProduct(Function function1, Function... functions) {
        this.functions = new Function[functions.length + 1];
        this.functions[0] = function1;

        for (int i = 0; i < functions.length; i++) {
            this.functions[i + 1] = functions[i];
        }
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
            Function[] otherFunctions = new Function[functions.length - 1];
            int index = 0;

            for (int j = 0; j < functions.length; j++) {
                if (j != i) {
                    otherFunctions[index] = functions[j];
                    index++;
                }
            }

            //Function productOfOtherFunctions = new MultiProduct(otherFunctions);
            //Function derivativeOfCurrentFunction = functions[i].derivative();

            derivatives[i] = new MultiProduct(functions[i].derivative(), otherFunctions);
        }
        // TEST TEST TEST
        //System.out.println("PRINT OF MULTI PRODUCT");
        //System.out.println(new MultiSum(derivatives));
        return new MultiSum(derivatives);
    }
}