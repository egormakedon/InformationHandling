package by.makedon.informationhandling.chain.impl.handler;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.texttool.TextTool;
import by.makedon.informationhandling.type.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements Handler {
    private Handler sentenceHandler;

    public ParagraphHandler(Handler sentenceHandler) {
        this.sentenceHandler = sentenceHandler;
    }

    @Override
    public void parse(Component textTool, String data, int i, int j) {
        final String PARAGRAPH_REGEXP = "\t.+\\.(?=\n)";
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEXP);
        Matcher matcher = paragraphPattern.matcher(data);
        while (matcher.find()) {
            String paragraph = matcher.group();
            Component paragraphTool = new TextTool(TextType.PARAGRAPH);
            textTool.add(paragraphTool);
            sentenceHandler.parse(paragraphTool, paragraph, i, j);
        }
    }
}