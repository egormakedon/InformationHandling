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

    @Override
    public void add(Component component) {
        textTool.add(component);
    }

    @Override
    public TextType getTextType() {
        return textType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component component : textTool) {
            if (component.getTextType() == TextType.PARAGRAPH) {
                sb.append("   ");
            }
            if (component.getTextType() == TextType.LEXEME) {
                sb.append(" ");
            }
            if (component.getTextType() == TextType.PUNCTUATIONMARK) {
                if (component.toString().equals("-")) {
                    sb.append(" ");
                }
            }
            sb.append(component.toString());
            if (component.toString().equals(".")) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}