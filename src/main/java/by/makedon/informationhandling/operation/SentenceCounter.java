package by.makedon.informationhandling.operation;

import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.type.TextType;

public class SentenceCounter {
    public static int count(Component textTool) {
        int counter = 0;
        for (Component paragraphTool : textTool.getTextTool()) {
            for (Component sentenceTool : paragraphTool.getTextTool()) {
                StringBuilder sb = new StringBuilder();
                for (Component lexemeTool : sentenceTool.getTextTool()) {
                    sb.append(" ");
                    for (Component wordTool : lexemeTool.getTextTool()) {
                        for (Component symbol : wordTool.getTextTool()) {
                            if (symbol.getTextType() == TextType.SYMBOL) {
                                sb.append(symbol.toString());
                            }
                        }
                    }
                }
                String[] words = sb.toString().split(" ");
                final String NUMBER_REGEXP = "\\d+,\\d+";
                for (int indexI = 0; indexI < words.length - 1; indexI++) {
                    int wordsCounter = 0;
                    for (int indexJ = indexI + 1; indexJ < words.length; indexJ++) {
                        if (!words[indexI].matches(NUMBER_REGEXP) && words[indexI].toLowerCase().equals(words[indexJ].toLowerCase())) {
                            wordsCounter++;
                            break;
                        }
                    }
                    if (wordsCounter == 1) {
                        counter++;
                        break;
                    }
                }
            }
        }
        return counter;
    }
}