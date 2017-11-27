package by.makedon.informationhandling.composite.impl.leaf;

import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.type.SymbolType;
import by.makedon.informationhandling.type.TextType;

public class Symbol implements Component {
    private char symbol;
    private TextType textType;
    private SymbolType symbolType;

    public Symbol(char symbol, TextType textType, SymbolType symbolType) {
        this.symbol = symbol;
        this.textType = textType;
        this.symbolType = symbolType;
    }

    @Override
    public void add(Component component) {
        //////////////////
    }
}