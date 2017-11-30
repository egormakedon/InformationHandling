package by.makedon.informationhandling.calculator;

import by.makedon.informationhandling.interpreter.impl.InterpreterImpl;
import by.makedon.informationhandling.parser.ReversePolishNotationParser;

public class ExpressionCalculator {
    public String calculate(String expression, int i, int j) {
        expression = replaceIncrementDecrementIJ(expression, i, j);
        expression = String.join("", expression.split("\\s"));
        expression = replaceNegativeNumbers(expression);
        ReversePolishNotationParser parser = new ReversePolishNotationParser();
        expression = parser.parse(expression);
        InterpreterImpl interpreter = new InterpreterImpl();
        return interpreter.calculate(expression).toString();
    }

    private String replaceIncrementDecrementIJ(String expression, int i, int j) {
        int incrementI = i + 1;
        int decrementI = i - 1;
        int incrementJ = j + 1;
        int decrementJ = j - 1;

        final String INCREMENT_I_REGEXP = "(\\+\\+i)|(i\\+\\+)";
        final String DECREMENT_I_REGEXP = "(--i)|(i--)";
        final String INCREMENT_J_REGEXP = "(\\+\\+j)|(j\\+\\+)";
        final String DECREMENT_J_REGEXP = "(--j)|(j--)";

        expression = expression.replaceAll(INCREMENT_I_REGEXP, String.valueOf(incrementI));
        expression = expression.replaceAll(DECREMENT_I_REGEXP, String.valueOf(decrementI));
        expression = expression.replaceAll(INCREMENT_J_REGEXP, String.valueOf(incrementJ));
        expression = expression.replaceAll(DECREMENT_J_REGEXP, String.valueOf(decrementJ));

        return expression;
    }

    private String replaceNegativeNumbers(String expression) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < expression.length(); index++) {
            char symbol = expression.charAt(index);
            if (symbol == '-') {
                if (index == 0) {
                    sb.append(0);
                    sb.append(symbol);
                } else {
                    char preSymbol = expression.charAt(index - 1);
                    final String SYMBOL_REGEXP = "[^0-9)]";
                    if (String.valueOf(preSymbol).matches(SYMBOL_REGEXP)) {
                        sb.append(0);
                        sb.append(symbol);
                    } else {
                        sb.append(symbol);
                    }
                }
            } else {
                sb.append(symbol);
            }
        }
        return sb.toString();
    }
}
