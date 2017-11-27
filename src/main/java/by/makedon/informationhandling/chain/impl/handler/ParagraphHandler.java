package by.makedon.informationhandling.chain.impl.handler;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.composite.Component;

public class ParagraphHandler implements Handler {
    private Handler sentenceHandler;

    public ParagraphHandler(Handler sentenceHandler) {
        this.sentenceHandler = sentenceHandler;
    }

    @Override
    public void parse(Component text, String data, int i, int j) {
        final String PARAGRAPH_REGEXP = "\t.+\\.(?=\n)";
        String[] paragraphs = data.split(PARAGRAPH_REGEXP);

    }
}