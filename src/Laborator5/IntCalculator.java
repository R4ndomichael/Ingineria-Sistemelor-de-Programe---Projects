package Laborator5;

public class IntCalculator {

    int state;

    public IntCalculator(int newState) {
        state = newState;
    }

    public IntCalculator add(int a){
        state += a;
        return this;
    }
    public IntCalculator subtract(int a){
        state -= a;
        return this;
    }
    public IntCalculator multiply(int a){
        state *= a;
        return this;
    }

    public int result(){
        return state;
    }

    void clear(){
        state = 0;
    }

}

class AdvancedCalculator extends IntCalculator{

    public AdvancedCalculator(int newState) {
        super(newState);
    }

    public IntCalculator divide(int a){
        state /= a;
        return this;
    }

    public IntCalculator power(int a){
        state ^= a;
        return this;
    }

    public IntCalculator sqrt(int a){
        state = (int) Math.pow(state, 1.0 / a);
        return this;
    }

}
