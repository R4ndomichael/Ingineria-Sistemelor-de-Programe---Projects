package Laborator5_Advanced;

public class DoubleCalculator extends ACalculator {

    public DoubleCalculator(Double value) {
        state = value;
    }

    public DoubleCalculator add(Double a) {
        state = (Double) state + a;
        return this;
    }

    public DoubleCalculator subtract(Double a) {
        state = (Double) state - a;
        return this;
    }

    public DoubleCalculator multiply(Double a) {
        state = (Double) state * a;
        return this;
    }

    protected void init() {
        state = 0.0;
    }
}