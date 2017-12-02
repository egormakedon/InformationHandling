package operation;

import by.makedon.informationhandling.chain.impl.parser.Parser;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.exception.IncorrectFileException;
import by.makedon.informationhandling.operation.LexemeRemover;
import by.makedon.informationhandling.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LexemeRemoverTest {
    @Test
    public void removeTest() throws IncorrectFileException {
        TextReader textReader = new TextReader();
        String text = textReader.readFile("testFile/testFileForLexemeRemover.txt");
        Parser parser = new Parser();
        Component c = parser.parse(text, 0, 0);
        LexemeRemover.remove(c, 6, 'g');
        String result = c.toString();
        String expected = "    Hello, Egor 6,00 (five).\n";
        Assert.assertEquals(result, expected);
    }
}
