package by.makedon.informationhandling.chain;

import by.makedon.informationhandling.composite.Component;

public interface Handler {
    void parse(Component component, String data, int i, int j);
}