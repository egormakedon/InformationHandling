package by.makedon.informationhandling.composite.impl.leaf;

import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.type.TextType;

public class Symbol implements Component {
    private char symbol;
    private TextType textType;

    public Symbol(char symbol, TextType textType) {
        this.symbol = symbol;
        this.textType = textType;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public TextType getTextType() {
        return textType;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}