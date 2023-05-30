public abstract class Function {

    public abstract double valueAt(double x);

    public abstract String toString();

    public abstract Function derivative();

    public abstract double bisectionMethod(double a, double b, double epsilon);

    public abstract double newtonRaphsonMethod(double a, double b);

    public abstract double newtonRaphsonMethod(double a);

    public abstract String taylorPolynomial(int n);
}
