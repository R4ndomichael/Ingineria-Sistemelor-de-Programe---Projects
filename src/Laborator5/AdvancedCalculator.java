package Laborator5;

import Laborator5.IntCalculator;

public class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int newState) {
        super(newState);
    }

    public AdvancedCalculator divide(int a) {
        int state = a;
        return this;
    }

    public AdvancedCalculator power(int a) {
        state = (int) Math.pow(state, a);
        return this;
    }

    public AdvancedCalculator root(int a) {
        state = (int) Math.pow(state, 1.0 / a);
        return this;
    }
}