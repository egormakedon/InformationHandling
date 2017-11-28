package by.makedon.informationhandling.chain.impl.handler;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.texttool.TextTool;
import by.makedon.informationhandling.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler implements Handler {
    private Handler wordExpressionHandler;

    public LexemeHandler(Handler wordExpressionHandler) {
        this.wordExpressionHandler = wordExpressionHandler;
    }

    @Override
    public void parse(Component sentenceTool, String data, int i, int j) {
        final String LEXEME_REGEXP = "(\\s.+?(?=\\s)(?!\\s-\\s))|(\\s.+\\.)";
        final String MATHEXP_REGEXP = "(--)|(\\+\\+)|(\\d)|([+*/])";

        Pattern lexemePattern = Pattern.compile(LEXEME_REGEXP);
        Pattern mathexpPattern = Pattern.compile(MATHEXP_REGEXP);
        Matcher lexemeMatcher = lexemePattern.matcher(data);

        List<String> lexemeList = new ArrayList<String>();
        List<Boolean> isLexemeMathExpList = new ArrayList<Boolean>();

        while (lexemeMatcher.find()) {
            String lexeme = lexemeMatcher.group();
            lexemeList.add(lexeme);

            if (mathexpPattern.matcher(lexeme).find()) {
                isLexemeMathExpList.add(true);
            } else {
                isLexemeMathExpList.add(false);
            }
        }

        List<String> newLexemeList = mergeMathExpLexemes(lexemeList, isLexemeMathExpList);
        for (String lexeme : newLexemeList) {
            Component lexemeTool = new TextTool(Type.LEXEME);
            sentenceTool.add(lexemeTool);
            wordExpressionHandler.parse(lexemeTool, lexeme, i, j);
        }
    }

    private List<String> mergeMathExpLexemes (List<String> lexemeList, List<Boolean> isLexemeMathExpList) {
        List<String> newLexemeList = new ArrayList<String>();
        for (int index = 0; index < isLexemeMathExpList.size(); index++) {
            if (isLexemeMathExpList.get(index)) {
                int chainOfMathExp = 0;
                for (int newIndex = index + 1; newIndex < isLexemeMathExpList.size(); newIndex++) {
                    if (isLexemeMathExpList.get(newIndex)) {
                        chainOfMathExp++;
                    } else {
                        break;
                    }
                }
                if (chainOfMathExp == 0) {
                    newLexemeList.add(lexemeList.get(index));
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int newIndex = index; newIndex <= index + chainOfMathExp; newIndex++) {
                        sb.append(lexemeList.get(newIndex));
                    }
                    newLexemeList.add(sb.toString());
                    index += chainOfMathExp;
                }
            } else {
                newLexemeList.add(lexemeList.get(index));
            }
        }
        return newLexemeList;
    }
}
