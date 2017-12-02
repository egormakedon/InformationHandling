package by.makedon.informationhandling.composite;

import by.makedon.informationhandling.type.TextType;

import java.util.List;

public interface Component {
    void add(Component component);
    String toString();
    TextType getTextType();
    List<Component> getTextTool();
}