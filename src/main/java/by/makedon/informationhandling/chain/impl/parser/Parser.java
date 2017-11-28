package by.makedon.informationhandling.chain.impl.parser;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.chain.impl.handler.LexemeHandler;
import by.makedon.informationhandling.chain.impl.handler.ParagraphHandler;
import by.makedon.informationhandling.chain.impl.handler.SentenceHandler;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.texttool.TextTool;
import by.makedon.informationhandling.type.TextType;

public class Parser {
    private Handler lexemeHandler;
    private Handler sentenceHandler;
    private Handler paragraphHandler;
    private Component textTool;

    public Parser() {
        lexemeHandler = new LexemeHandler();
        sentenceHandler = new SentenceHandler(lexemeHandler);
        paragraphHandler = new ParagraphHandler(sentenceHandler);
        textTool = new TextTool(TextType.TEXT);
    }

    public Component parse(String data, int i, int j) {
        paragraphHandler.parse(textTool, data, i, j);
        return textTool;
    }
}