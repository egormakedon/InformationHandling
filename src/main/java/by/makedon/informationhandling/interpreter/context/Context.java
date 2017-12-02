package by.makedon.informationhandling.interpreter.context;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
    private Deque<Double> values;
    public Context() {
        values = new ArrayDeque<Double>();
    }
    public Double popValue() {
        return values.pop();
    }
    public void pushValue(Double value) {
        values.push(value);
    }
}