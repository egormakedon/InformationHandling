package by.makedon.informationhandling.chain.impl.handler;

import by.makedon.informationhandling.calculator.ExpressionCalculator;
import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.texttool.TextTool;
import by.makedon.informationhandling.type.TextType;

import java.util.regex.Pattern;

public class WordExpressionHandler implements Handler {
    private Handler symbolHandler;

    public WordExpressionHandler(Handler symbolHandler) {
        this.symbolHandler = symbolHandler;
    }

    @Override
    public void parse(Component lexemeTool, String data, int i, int j) {
        final String MATHEXP_REGEXP = "(--)|(\\+\\+)|(\\d)|([+*/])";
        Pattern mathexpPattern = Pattern.compile(MATHEXP_REGEXP);
        if (mathexpPattern.matcher(data).find()) {
            ExpressionCalculator calculator = new ExpressionCalculator();
            String expression = calculator.calculate(data, i, j);
            Component expressionTool = new TextTool(TextType.EXPRESSION);
            lexemeTool.add(expressionTool);
            symbolHandler.parse(expressionTool, expression, i, j);
        } else {
            String word = String.join("", data.split("\\s"));
            Component wordTool = new TextTool(TextType.WORD);
            lexemeTool.add(wordTool);
            symbolHandler.parse(wordTool, word, i, j);
        }
    }
}