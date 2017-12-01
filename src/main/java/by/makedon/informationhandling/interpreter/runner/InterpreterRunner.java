package by.makedon.informationhandling.interpreter.runner;

import by.makedon.informationhandling.exception.InvalidArgumentException;
import by.makedon.informationhandling.interpreter.Interpreter;
import by.makedon.informationhandling.interpreter.context.Context;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class InterpreterRunner {
    private final static Logger LOGGER = LogManager.getLogger(InterpreterRunner.class);

    private List<Interpreter> commandList;
    private Context context;

    public InterpreterRunner() {
        commandList = new ArrayList<Interpreter>();
        context = new Context();
    }

    public String calculate(String expression) {
        parse(expression);
        for (Interpreter command : commandList) {
            command.interpret();
        }
        return String.format("%(.2f)", context.popValue());
    }

    private void parse(String expression) {
        String[] args = expression.split("\\s");
        for (String arg : args) {
            addCommand(arg);
        }
    }

    private void addCommand(String arg) {
        switch (arg) {
            case "+":
                commandList.add(new Interpreter() {
                    @Override
                    public void interpret() {
                        Double arg2 = context.popValue();
                        Double arg1 = context.popValue();
                        context.pushValue(arg1 + arg2);
                    }
                });
                break;
            case "-":
                commandList.add(new Interpreter() {
                    @Override
                    public void interpret() {
                        Double arg2 = context.popValue();
                        Double arg1 = context.popValue();
                        context.pushValue(arg1 - arg2);
                    }
                });
                break;
            case "*":
                commandList.add(new Interpreter() {
                    @Override
                    public void interpret() {
                        Double arg2 = context.popValue();
                        Double arg1 = context.popValue();
                        context.pushValue(arg1 * arg2);
                    }
                });
                break;
            case "/":
                commandList.add(new Interpreter() {
                    @Override
                    public void interpret() {
                        Double arg2 = context.popValue();
                        Double arg1 = context.popValue();
                        context.pushValue(arg1 / arg2);
                    }
                });
                break;
            default:
                final String NUMBER_REGEXP = "\\d";
                if (arg.matches(NUMBER_REGEXP)) {
                    commandList.add(new Interpreter() {
                        @Override
                        public void interpret() {
                            context.pushValue(Double.valueOf(arg));
                        }
                    });
                } else {
                    LOGGER.log(Level.ERROR, "Failed argument in expression");
                    throw new InvalidArgumentException();
                }
        }
    }
}