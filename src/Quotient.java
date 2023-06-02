public class Quotient extends Function {
    Function function1;
    Function function2;

    public Quotient(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    // IF FUNCTION2 = 0
    @Override
    public double valueAt(double x) {
        return function1.valueAt(x)/function2.valueAt(x);
    }

    //?????????????????????????????????????
    @Override
    public String toString() {
        return function1.toString() + function2.toString();
    }

    //NEED TO USE THE PRODUCT FUNCTION???
    @Override
    public Function derivative() {
        return new Quotient((new Sum((new Product(function1.derivative(), function2)),
                new Negation(new Product(function1, function2.derivative())))), new Power(function2, 2));
    }

}
