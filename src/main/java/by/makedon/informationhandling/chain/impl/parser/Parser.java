package by.makedon.informationhandling.chain.impl.parser;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.chain.impl.handler.ParagraphHandler;
import by.makedon.informationhandling.chain.impl.handler.SentenceHandler;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.texttool.TextTool;
import by.makedon.informationhandling.type.TextType;

public class Parser {
    private Handler paragraphHandler;
    private Handler sentenceHandler;
    private Component textTool;

    public Parser() {
        sentenceHandler = new SentenceHandler();
        paragraphHandler = new ParagraphHandler(sentenceHandler);
        textTool = new TextTool(TextType.TEXT);
    }

    public Component parse(String data, int i, int j) {
        paragraphHandler.parse(textTool, data, i, j);
        return textTool;
    }
}