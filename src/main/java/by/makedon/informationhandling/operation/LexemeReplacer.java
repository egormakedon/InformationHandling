package by.makedon.informationhandling.operation;

import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.leaf.Symbol;
import by.makedon.informationhandling.type.TextType;

public class LexemeReplacer {
    public static void replace(Component textTool) {
        for (Component paragraphTool : textTool.getTextTool()) {
            for (Component sentenceTool : paragraphTool.getTextTool()) {
                int size = sentenceTool.getTextTool().size();
                if (size == 2) {
                    Component firstLexeme = takeFirstLexeme(sentenceTool);
                    Component lastLexeme = takeLastLexeme(sentenceTool);
                    sentenceTool.getTextTool().clear();
                    sentenceTool.add(lastLexeme);
                    sentenceTool.add(firstLexeme);
                } else if (size > 2) {
                    Component firstLexeme = takeFirstLexeme(sentenceTool);
                    Component lastLexeme = takeLastLexeme(sentenceTool);
                    sentenceTool.getTextTool().remove(0);
                    sentenceTool.getTextTool().remove(size - 2);
                    sentenceTool.getTextTool().add(0, lastLexeme);
                    sentenceTool.getTextTool().add(size - 1, firstLexeme);
                }
            }
        }
    }

    private static Component takeFirstLexeme(Component sentenceTool) {
        Component firstLexeme = sentenceTool.getTextTool().get(0);
        Component word = firstLexeme.getTextTool().get(0);
        word.add(new Symbol('.', TextType.PUNCTUATIONMARK));
        return firstLexeme;
    }

    private static Component takeLastLexeme(Component sentenceTool) {
        int sentenceSize = sentenceTool.getTextTool().size();
        Component lastLexeme = sentenceTool.getTextTool().get(sentenceSize - 1);
        Component word = lastLexeme.getTextTool().get(0);
        word.getTextTool().remove(word.getTextTool().size() - 1);
        return lastLexeme;
    }
}