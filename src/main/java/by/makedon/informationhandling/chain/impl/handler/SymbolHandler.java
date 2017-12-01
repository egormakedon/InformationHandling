package by.makedon.informationhandling.chain.impl.handler;

import by.makedon.informationhandling.chain.Handler;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.composite.impl.leaf.Symbol;
import by.makedon.informationhandling.type.TextType;

import java.util.regex.Pattern;

public class SymbolHandler implements Handler {
    @Override
    public void parse(Component wordExpressionTool, String data, int i, int j) {
        final String PUNCTUATIONMARK_REGEXP = "[.:;,()']";
        Pattern punctuationMarkPattern = Pattern.compile(PUNCTUATIONMARK_REGEXP);
        String[] symbols = data.split("");
        for (int index = 0; index < symbols.length; index++) {
            Component symbolLeaf;
            if (punctuationMarkPattern.matcher(symbols[index]).matches()) {
                symbolLeaf = new Symbol(symbols[index].charAt(0), TextType.PUNCTUATIONMARK);
            } else {
                char symbol = symbols[index].charAt(0);
                if (symbol == '-') {
                    if (index == symbols.length - 1) {
                        symbolLeaf = new Symbol(symbols[index].charAt(0), TextType.PUNCTUATIONMARK);
                    } else {
                        symbolLeaf = new Symbol(symbols[index].charAt(0), TextType.SYMBOL);
                    }
                } else {
                    symbolLeaf = new Symbol(symbols[index].charAt(0), TextType.SYMBOL);
                }
            }
            wordExpressionTool.add(symbolLeaf);
        }
    }
}