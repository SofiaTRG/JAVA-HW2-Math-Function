public class Difference extends Function{
    Function function1;
    Function function2;

    public Difference(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) - function2.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + " - " + function2.toString() + ")";
    }

    @Override
    public Function derivative() {
        return new Difference(function1.derivative(), function2.derivative());
    }
}
