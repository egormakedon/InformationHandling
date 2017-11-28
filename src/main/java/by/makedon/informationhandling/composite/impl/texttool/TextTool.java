package by.makedon.informationhandling.composite.impl.texttool;

import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.type.Type;

import java.util.ArrayList;
import java.util.List;

public class TextTool implements Component {
    private List<Component> textTool;
    private Type type;

    public TextTool(Type type) {
        textTool = new ArrayList<Component>();
        this.type = type;
    }

    public void add(Component component) {
        textTool.add(component);
    }
}