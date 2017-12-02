package operation;

import by.makedon.informationhandling.chain.impl.parser.Parser;
import by.makedon.informationhandling.composite.Component;
import by.makedon.informationhandling.exception.IncorrectFileException;
import by.makedon.informationhandling.operation.LexemeReplacer;
import by.makedon.informationhandling.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LexemeReplacerTest {
    @Test
    public void replaceTest() throws IncorrectFileException {
        TextReader textReader = new TextReader();
        String text = textReader.readFile("testFile/testFileForLexemeReplacer.txt");
        Parser parser = new Parser();
        Component c = parser.parse(text, 0, 0);
        LexemeReplacer.replace(c);
        String result = c.toString();
        String exprexted = "    replacer epam Egor.\n    mm epammm Epam.\n";
        Assert.assertEquals(result, exprexted);
    }
}
