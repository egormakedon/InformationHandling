package by.makedon.informationhandling.interpreter.impl;

import by.makedon.informationhandling.interpreter.Expression;
import by.makedon.informationhandling.interpreter.context.Context;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Interpreter {
    private final static Logger LOGGER = LogManager.getLogger(Interpreter.class);

    private List<Expression> terminalExpressionList;
    private Context context;

    public Interpreter() {
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
        final String OPERATION_SPLITTER = "[+\\-*/]";
        final String NUMBER_SPLITTER = "[\\d\\s]";

        String[] numbers = expression.split(OPERATION_SPLITTER);
        String[] operations = expression.split(NUMBER_SPLITTER);

        for (String number : numbers) {
            if (!number.equals(" "))
            addContext(number);
        }

        for (String operation : operations) {
            if (!operation.equals("")) {
                addTerminalExpression(operation);
            }
        }
    }

    private void addContext(String number) {
        number = number.trim();
        String[] numbers = number.split(" ");
        for (int index = numbers.length - 1; index >= 0; index--) {
            context.addLastValue(Double.valueOf(numbers[index]));
        }
    }

    private void addTerminalExpression(String operation) {
        switch (operation) {
            case "+":
                terminalExpressionList.add(new Expression() {
                    @Override
                    public void interpret() {
                        Double arg2 = context.popValue().doubleValue();
                        Double arg1 = context.popValue().doubleValue();
                        context.pushValue(arg1 + arg2);
                    }
                });
                break;
            case "-":
                terminalExpressionList.add(new Expression() {
                    @Override
                    public void interpret() {
                        Double arg2 = context.popValue().doubleValue();
                        Double arg1 = context.popValue().doubleValue();
                        context.pushValue(arg1 - arg2);
                    }
                });
                break;
            case "*":
                terminalExpressionList.add(new Expression() {
                    @Override
                    public void interpret() {
                        Double arg2 = context.popValue().doubleValue();
                        Double arg1 = context.popValue().doubleValue();
                        context.pushValue(arg1 * arg2);
                    }
                });
                break;
            case "/":
                terminalExpressionList.add(new Expression() {
                    @Override
                    public void interpret() {
                        Double arg2 = context.popValue().doubleValue();
                        Double arg1 = context.popValue().doubleValue();
                        context.pushValue(arg1 / arg2);
                    }
                });
                break;
            default:
                LOGGER.log(Level.ERROR, "Illegal operation in expression");
                throw new RuntimeException();
        }
    }
}