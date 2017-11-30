package by.makedon.informationhandling.interpreter.impl;

import by.makedon.informationhandling.interpreter.Expression;
import by.makedon.informationhandling.interpreter.context.Context;

import java.util.ArrayList;
import java.util.List;

public class InterpreterImpl {
    private List<Expression> terminalExpressionList;
    private Context context;

    public InterpreterImpl() {
        terminalExpressionList = new ArrayList<Expression>();
        context = new Context();
    }

    public Number calculate(String expression) {
        parse(expression);
        for (Expression terminal : terminalExpressionList) {
            terminal.interpret();
        }
        return context.popValue();
    }

    private void parse(String expression) {

    }
}
