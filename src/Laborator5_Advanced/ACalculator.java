package Laborator5_Advanced;

public abstract class ACalculator {

    protected Object state;

    public Object result() {
        return state;
    }

    public ACalculator clear() {
        init();
        return this;
    }

    protected abstract void init();
}