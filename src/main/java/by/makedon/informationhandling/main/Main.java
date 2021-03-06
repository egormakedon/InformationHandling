package by.makedon.informationhandling.main;

import by.makedon.informationhandling.chain.impl.parser.Parser;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.exception.IncorrectFileException;
import by.makedon.informationhandling.operation.LexemeRemover;
import by.makedon.informationhandling.operation.LexemeReplacer;
import by.makedon.informationhandling.operation.SentenceCounter;
import by.makedon.informationhandling.reader.TextReader;

public class Main {
    public static void main(String[] args) throws IncorrectFileException {
        TextReader textReader = new TextReader();
        String text = textReader.readFile("in/text.txt");
        Parser parser = new Parser();
        Component c = parser.parse(text, 0, 4);
        LexemeRemover.remove(c, 6, 'g');
        System.out.println(c.toString());
    }
}