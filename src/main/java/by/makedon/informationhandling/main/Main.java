package by.makedon.informationhandling.main;

import by.makedon.informationhandling.chain.impl.parser.Parser;
import by.makedon.informationhandling.exception.IncorrectFileException;
import by.makedon.informationhandling.reader.TextReader;

public class Main {
    public static void main(String[] args) throws IncorrectFileException {
        TextReader textReader = new TextReader();
        String text = textReader.readFile("in/testFileForReader.txt");
        Parser parser = new Parser();
        parser.parse(text, 0, 0);
    }
}
