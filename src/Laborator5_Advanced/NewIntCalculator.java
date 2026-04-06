package Laborator5_Advanced;

public class NewIntCalculator extends ACalculator {

    public NewIntCalculator(Integer value) {
        state = value;
    }

    public NewIntCalculator add(Integer a) {
        state = (Integer) state + a;
        return this;
    }

    public NewIntCalculator subtract(Integer a) {
        state = (Integer) state - a;
        return this;
    }

    public NewIntCalculator multiply(Integer a) {
        state = (Integer) state * a;
        return this;
    }

    protected void init() {
        state = 0;
    }
}