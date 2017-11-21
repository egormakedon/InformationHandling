package by.makedon.informationhandling.chain.impl.handler;

import by.makedon.informationhandling.chain.Handler;

public class ParagraphHandler implements Handler {
    private Handler nextHandler;

    public ParagraphHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void parse() {

    }
}