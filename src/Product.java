/**
 * the product class, function1*function2
 */
public class Product extends Function {
    private final Function function1;
    private final Function function2;

    /**
     * constructor
     * @param function1 the first function
     * @param function2 the second function
     */
    public Product(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    /**
     * give the value of f(x) by the given x. calculate the value this way: f1(x)*f2(x)
     * @param x the x we wnt to find it's f(x) value
     * @return f1(x)*f2(x)
     */
    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) * function2.valueAt(x);
    }

    /**
     * makes a string of the function
     * @return "(function1(x)*function2(x))" as string
     */
    @Override
    public String toString() {
        return "(" + function1.toString() + " * " + function2.toString() + ")";
    }

    /**
     * calculate the derivative: f1'(x)*f2(x) + f2'(x)*f1(x)
     * @return the derivative of the function
     */
    @Override
    public Function derivative() {
        return new Sum(new Product(function1.derivative(), function2), new Product(function2.derivative(), function1));
    }
}
