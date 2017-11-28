package by.makedon.informationhandling.composite.impl.leaf;

import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.type.Type;

public class Symbol implements Component {
    private char symbol;
    private Type type;

    public Symbol(char symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public void add(Component component) {
        //////////////////
    }
}