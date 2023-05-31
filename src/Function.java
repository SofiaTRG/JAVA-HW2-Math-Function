public abstract class Function {

    public abstract double valueAt(double x);

    public abstract String toString();

    public abstract Function derivative();

    public double bisectionMethod(double a, double b, double epsilon) {
        double mid;
        double left=a;
        double right=b;
        while(right-left > epsilon)
        {
            mid=(left+right)/2.0;
            if(valueAt(left)*valueAt(mid)>0)
                left=mid;
            else
                right=mid;

        }
        return ((left+right)/2);
    }

    public double bisectionMethod(double a,double b){
        return bisectionMethod(a,b,Math.pow(10,-5));
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        double root=a;
        while (Math.abs(valueAt(root)) >= epsilon)
        {
            root=root-(valueAt(root)/derivative().valueAt(root));
        }
        return root;
    }

    public double newtonRaphsonMethod(double a){
        return newtonRaphsonMethod(a,(double) Math.pow(10,-5));
    }


    public Function taylorPolynomial(int n) {
        if (n > 0) {
            double taylorArr[] = new double[n+1];
            Function derevite = this;
            taylorArr[0] = derevite.valueAt(0);
            derevite = derevite.derivative();
            double derivativ=1;
            for (int i = 1; i <= n; i++) {
                derivativ=(double) derivativ*i;
                taylorArr[i] = derevite.valueAt(0) / derivativ;
                derevite = derevite.derivative();
            }
            Polynomial tylorPol = new Polynomial(taylorArr);
            return tylorPol;
        }else return new Polynomial(this.valueAt(0));
    }


}
