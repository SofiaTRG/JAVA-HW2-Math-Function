/**
 * The abstract class of function. every son class will inherit from this class its methods
 */
public abstract class Function {

    /**
     * give the value of f(x) by the given x
     * @param x the x we wnt to find it's f(x) value
     * @return f(x)
     */
    public abstract double valueAt(double x);

    /**
     * makes a string of the function
     * @return returns the string
     */
    public abstract String toString();

    /**
     * the derivative of function
     * @return derivative
     */
    public abstract Function derivative();

    /**
     * bisection method. by given two values(the first values of left and right boundaries) and epsilon.
     * we change the left and right boundaries as we progress.
     * the algorithm stops when the desired precision is achieved
     * @param a left boundaries
     * @param b right boundaries
     * @param epsilon desired precision of the root approximation
     * @return desired precision of the root approximation
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        double middle;
        double left = a;
        double right = b;
        while(right - left > epsilon) {
            middle = (left+right)/2.0;
            if (valueAt(left) * valueAt(middle) > 0)
                left = middle;
            else
                right = middle;
        }
        return ((left+right) / 2);
    }

    /**
     * call the first bisection method, but set the epsilon 10^(-5)
     * @param a left boundaries
     * @param b right boundaries
     * @return desired precision of the root approximation
     */
    public double bisectionMethod(double a,double b){
        double epsilon = Math.pow(10,-5);
        return bisectionMethod(a, b, epsilon);
    }

    /**
     * search for approximate value near a with precision of epsilon.
     * @param a The initial guess for the root
     * @param epsilon the desired precision of the root approximation
     * @return The estimated root of the function.
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        double newton=a;
        while (Math.abs(valueAt(newton)) >= epsilon)
        {
            newton = newton - (valueAt(newton)/derivative().valueAt(newton));
        }
        return newton;
    }

    /**
     * call the first Newthon Raphson method with epsilon value 10^(-5)
     * @param a The initial guess for the root
     * @return The estimated root of the function.
     */
    public double newtonRaphsonMethod(double a){
        double epsilon = Math.pow(10, -5);
        return newtonRaphsonMethod(a, epsilon);
    }

    /**
     * makes the taylor polynomial of function. The method uses a loop to calculate the coefficients of the Taylor
     * polynomial by repeatedly taking derivatives of the function at 0 and dividing by the corresponding
     * factorial value.
     * @param n the degree of taylor
     * @return taylor polynomial at value x=0
     */
    public Function taylorPolynomial(int n) {
        if (n > 0) {
            double taylorArray[] = new double[n + 1];
            double factorial;
            Function derivative = this;
            for (int i = 0; i <= n; i++) {
                factorial = factorial(i);
                taylorArray[i] = (derivative.valueAt(0))/factorial;
                derivative = derivative.derivative();
            }
            Polynomial taylorPolynomial = new Polynomial(taylorArray);
            return taylorPolynomial;
        } else {
            return new Polynomial(this.valueAt(0));
        }
    }

    /**
     * calculate the factorial of a number.
     * @param i the number we want to calculate the factorial
     * @return i!
     */
    private double factorial(int i) {
        double factorial = 1;
        for (int k = 1; k <= i; k++) {
            factorial *= k;
        }
        return factorial;
    }

}