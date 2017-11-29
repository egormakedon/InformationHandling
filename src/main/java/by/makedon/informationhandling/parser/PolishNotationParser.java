package by.makedon.informationhandling.parser;

import java.util.regex.Pattern;

public class PolishNotationParser {
    private final String BRACKETS_REGEXP = "[()]";
    private Pattern bracketsPattern;

    public PolishNotationParser() {
        bracketsPattern = Pattern.compile(BRACKETS_REGEXP);
    }

    public String parse(String expression) {
        String parsedExpression;
        if (bracketsPattern.matcher(expression).find()) {
            parsedExpression = parseBetweenBrackets(expression);
        } else {
            parsedExpression = parseWithoutBrackets(expression);
        }
        return parsedExpression;
    }

    private String parseBetweenBrackets(String expression) {
        return null;
    }

    private String parseWithoutBrackets(String expression) {
        return null;
    }
}