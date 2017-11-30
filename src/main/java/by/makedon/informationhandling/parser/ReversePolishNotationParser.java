package by.makedon.informationhandling.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotationParser {
    private final static Logger LOGGER = LogManager.getLogger(ReversePolishNotationParser.class);

    private enum Operation {
        BRACKET(0), PLUS(1), MINUS(1), MULT(2), DIV(2);

        private int priority;

        Operation(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }
    }

    public String parse(String expression) {
        final String NUMBER_REGEXP = "[0-9]";
        StringBuilder out = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {
            char symbol = expression.charAt(index);
            if (String.valueOf(symbol).matches(NUMBER_REGEXP)) {
                out.append(" ");
                out.append(symbol);
                int chainOfNumbers = 0;
                for (int newIndex = index + 1; newIndex < expression.length(); newIndex++) {
                    char nextSymbol = expression.charAt(newIndex);
                    if (String.valueOf(nextSymbol).matches(NUMBER_REGEXP)) {
                        chainOfNumbers++;
                        out.append(nextSymbol);
                    } else {
                        break;
                    }
                }
                index += chainOfNumbers;
            } else if (symbol == '(') {
                stack.push(symbol);
            } else if (symbol == ')') {
                while (true) {
                    char symbolFromStack = stack.pop();
                    if (symbolFromStack == '(') {
                        break;
                    } else {
                        out.append(" ");
                        out.append(symbolFromStack);
                    }
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(symbol);
                } else {
                    int priorityOfSymbol = getPriority(symbol);
                    while (true) {
                        int priorityOfSymbolFromStack = getPriority(stack.getFirst());

                        if (priorityOfSymbol > priorityOfSymbolFromStack) {
                            stack.push(symbol);
                            break;
                        } else {
                            out.append(" ");
                            out.append(stack.pop());
                        }
                        if (stack.isEmpty()) {
                            stack.push(symbol);
                            break;
                        }
                    }
                }
            }
        }
        while (stack.size() > 0) {
            out.append(" ");
            out.append(stack.pop());
        }
        return out.toString().trim();
    }

    private int getPriority(char operation) {
        int result;
        switch (operation) {
            case '/':
                result = Operation.DIV.getPriority();
                break;
            case '*':
                result = Operation.MULT.getPriority();
                break;
            case '-':
                result = Operation.MINUS.getPriority();
                break;
            case '+':
                result = Operation.PLUS.getPriority();
                break;
            case '(':
                result = Operation.BRACKET.getPriority();
                break;
            default:
                LOGGER.log(Level.ERROR, "Failed argument in expression");
                throw new RuntimeException();
        }
        return result;
    }
}