package by.makedon.informationhandling.chain.impl.parser;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.chain.impl.handler.*;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.texttool.TextTool;
import by.makedon.informationhandling.type.TextType;

public class Parser {
    private Handler symbolHandler;
    private Handler wordExpressionHandler;
    private Handler lexemeHandler;
    private Handler sentenceHandler;
    private Handler paragraphHandler;
    private Component textTool;

    public Parser() {
        symbolHandler = new SymbolHandler();
        wordExpressionHandler = new WordExpressionHandler(symbolHandler);
        lexemeHandler = new LexemeHandler(wordExpressionHandler);
        sentenceHandler = new SentenceHandler(lexemeHandler);
        paragraphHandler = new ParagraphHandler(sentenceHandler);
        textTool = new TextTool(TextType.TEXT);
    }

    public Component parse(String data, int i, int j) {
        paragraphHandler.parse(textTool, data, i, j);
        return textTool;
    }
}