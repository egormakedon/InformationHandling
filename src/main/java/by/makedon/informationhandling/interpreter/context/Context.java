package by.makedon.informationhandling.interpreter.context;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
    private Deque<Number> values;

    public Context() {
        values = new ArrayDeque<Number>();
    }

    public Number popValue() {
        return values.pop();
    }

    public void pushValue(Number value) {
        values.push(value);
    }

    public void addLastValue(Number value) {
        values.addLast(value);
    }
}