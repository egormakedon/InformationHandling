package by.makedon.informationhandling.composite.impl.texttool;

import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.type.TextType;

import java.util.ArrayList;
import java.util.List;

public class TextTool implements Component {
    private List<Component> textTool;
    private TextType textType;

    public TextTool(TextType textType) {
        textTool = new ArrayList<Component>();
        this.textType = textType;
    }

    public void add(Component component) {
        textTool.add(component);
    }
}