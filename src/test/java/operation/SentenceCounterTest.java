package operation;

import by.makedon.informationhandling.chain.impl.parser.Parser;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.exception.IncorrectFileException;
import by.makedon.informationhandling.operation.SentenceCounter;
import by.makedon.informationhandling.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SentenceCounterTest {
    @Test
    public void countTest() throws IncorrectFileException {
        TextReader textReader = new TextReader();
        String text = textReader.readFile("testFile/testFileForCounter.txt");
        Parser parser = new Parser();
        Component c = parser.parse(text, 0, 0);
        int result = SentenceCounter.count(c);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }
}
