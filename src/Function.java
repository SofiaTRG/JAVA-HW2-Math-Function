public abstract class Function {

    public abstract double valueAt(double x);

    public abstract String toString();

    public abstract Function derivative();

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

    public double bisectionMethod(double a,double b){
        double epsilon = Math.pow(10,-5);
        return bisectionMethod(a, b, epsilon);
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        double newton=a;
        while (Math.abs(valueAt(newton)) >= epsilon)
        {
            newton = newton - (valueAt(newton)/derivative().valueAt(newton));
        }
        return newton;
    }

    public double newtonRaphsonMethod(double a){
        double epsilon = Math.pow(10, -5);
        return newtonRaphsonMethod(a, epsilon);
    }

    public Function taylorPolynomial(int n) {
        if (n > 0) {
            double taylorArr[] = new double[n + 1];
            Function derivative = this;
            for (int i = 0; i <= n; i++) {
                taylorArr[i] = derivative.valueAt(0);
                derivative = derivative.derivative();
            }
            Polynomial taylorPolynomial = new Polynomial(taylorArr);
            return taylorPolynomial;
        } else {
            return new Polynomial(this.valueAt(0));
        }
    }

}