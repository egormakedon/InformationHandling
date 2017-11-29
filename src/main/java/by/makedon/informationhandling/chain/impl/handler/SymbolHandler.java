package by.makedon.informationhandling.chain.impl.handler;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.leaf.Symbol;
import by.makedon.informationhandling.type.TextType;

import java.util.regex.Pattern;

public class SymbolHandler implements Handler {
    @Override
    public void parse(Component wordExpressionTool, String data, int i, int j) {
        final String PUNCTUATIONMARK_REGEXP = "[.:;,\\-()']";
        Pattern punctuationMarkPattern = Pattern.compile(PUNCTUATIONMARK_REGEXP);
        String[] symbols = data.split("");
        for (String symbol : symbols) {
            Component symbolLeaf;
            if (punctuationMarkPattern.matcher(symbol).matches()) {
                symbolLeaf = new Symbol(symbol.charAt(0), TextType.PUNCTUATIONMARK);
            } else {
                symbolLeaf = new Symbol(symbol.charAt(0), TextType.SYMBOL);
            }
            wordExpressionTool.add(symbolLeaf);
        }
    }
}
