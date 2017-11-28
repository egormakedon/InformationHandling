package by.makedon.informationhandling.chain.impl.handler;

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
            data = replaceIncrementDecrementIJ(data, i, j);
        } else {
            String word = String.join("", data.split("\\s"));
            Component wordTool = new TextTool(TextType.WORD);
            lexemeTool.add(wordTool);
            symbolHandler.parse(wordTool, word, i, j);
        }
    }

    private String replaceIncrementDecrementIJ(String data, int i, int j) {
        int incrementI = i + 1;
        int decrementI = i - 1;
        int incrementJ = j + 1;
        int decrementJ = j - 1;

        final String INCREMENT_I_REGEXP = "(\\+\\+i)|(i\\+\\+)";
        final String DECREMENT_I_REGEXP = "(--i)|(i--)";
        final String INCREMENT_J_REGEXP = "(\\+\\+j)|(j\\+\\+)";
        final String DECREMENT_J_REGEXP = "(--j)|(j--)";

        data = data.replaceAll(INCREMENT_I_REGEXP, String.valueOf(incrementI));
        data = data.replaceAll(DECREMENT_I_REGEXP, String.valueOf(decrementI));
        data = data.replaceAll(INCREMENT_J_REGEXP, String.valueOf(incrementJ));
        data = data.replaceAll(DECREMENT_J_REGEXP, String.valueOf(decrementJ));

        return data;
    }
}