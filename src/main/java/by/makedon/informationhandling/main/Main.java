package by.makedon.informationhandling.main;

import by.makedon.informationhandling.chain.impl.parser.Parser;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.exception.IncorrectFileException;
import by.makedon.informationhandling.reader.TextReader;

public class Main {
    public static void main(String[] args) throws IncorrectFileException {
        TextReader textReader = new TextReader();
        String text = textReader.readFile("in/text.txt");
        Parser parser = new Parser();
        Component c = parser.parse(text, 0, 4);
        System.out.println(c.toString());
    }
}