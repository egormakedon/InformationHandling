package by.makedon.informationhandling.chain.impl.handler;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.texttool.TextTool;
import by.makedon.informationhandling.type.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements Handler {
    ////

    public SentenceHandler() {

    }

    @Override
    public void parse(Component paragraphTool, String data, int i, int j) {
        final String SENTENCE_REGEXP = "\\s.+?\\.";
        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEXP);
        Matcher matcher = sentencePattern.matcher(data);
        while (matcher.find()) {
            String sentence = matcher.group();
            Component sentenceTool = new TextTool(TextType.SENTENCE);
            paragraphTool.add(sentenceTool);
            //sentenceHandler.parse(sentenceTool, sentence, i, j);
        }
    }
}