package by.makedon.informationhandling.operation;

import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.type.TextType;

import java.util.ArrayList;
import java.util.List;

public class LexemeRemover {
    public static void remove(Component textTool, int length, char letter) {
        List<Component> listOfLexemes = new ArrayList<Component>();
        for (Component paragraphTool : textTool.getTextTool()) {
            for (Component sentenceTool : paragraphTool.getTextTool()) {
                for (Component lexemeTool : sentenceTool.getTextTool()) {
                    for (Component wordTool : lexemeTool.getTextTool()) {
                        StringBuilder sb = new StringBuilder();
                        Character firstLetter = null;
                        for (Component symbol : wordTool.getTextTool()) {
                            sb.append(symbol.toString());
                            if (symbol.getTextType() == TextType.SYMBOL && firstLetter == null) {
                                firstLetter = symbol.toString().charAt(0);
                            }
                        }
                        int size = sb.toString().length() + 2;
                        if (sb.toString().charAt(sb.toString().length() - 1) == '-') {
                            size++;
                        }
                        if (size == length && firstLetter == letter) {
                            listOfLexemes.add(lexemeTool);
                        }
                    }
                }
            }
        }
        for (Component paragraphTool : textTool.getTextTool()) {
            for (Component sentenceTool : paragraphTool.getTextTool()) {
                for (int index = 0; index < listOfLexemes.size(); index++) {
                    sentenceTool.remove(listOfLexemes.get(index));
                }
            }
        }
    }
}
