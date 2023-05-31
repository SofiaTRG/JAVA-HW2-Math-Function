public class Power extends Function {

        private Function function;
        private int exponent;

        public Power(Function function,int exponent) {
            this.function = function;
            this.exponent = exponent;
        }


        @Override
        public double valueAt(double x) {
            return Math.pow(function.valueAt(x), exponent);
        }

        @Override
        public String toString() {
            return "(" + function.toString() + ")^" + exponent;
        }

        @Override
        public Function derivative() {

        }
    }

