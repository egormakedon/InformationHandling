package by.makedon.informationhandling.chain.impl.parser;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.chain.impl.handler.ParagraphHandler;
import by.makedon.informationhandling.chain.impl.handler.SentenceHandler;

public class Parser implements Handler {
    private Handler paragraphHandler;
    private Handler sentenceHandler;
//    private
//
//    public Parser() {
//        sentenceHandler = new SentenceHandler();
//        paragraphHandler = new ParagraphHandler(sentenceHandler);
//    }

    public void parse() {

    }
}
