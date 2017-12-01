package by.makedon.informationhandling.composite;

import by.makedon.informationhandling.type.TextType;

public interface Component {
    void add(Component component);
    String toString();
    TextType getTextType();
}