public class Product extends Function {
    private final Function function1;
    private final Function function2;

    public Product(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }
    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) * function2.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + " * " + function2.toString() + ")";
    }

    @Override
    public Function derivative() {
        //Function derivative1 = function1.derivative();
        //Function derivative2 = function2.derivative();
        return new Sum(new Product(function1.derivative(), function2), new Product(function2.derivative(), function1));
    }
}
