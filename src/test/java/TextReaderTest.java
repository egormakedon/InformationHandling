import by.makedon.informationhandling.exception.IncorrectFileException;
import by.makedon.informationhandling.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextReaderTest {
    private TextReader textReader;

    @BeforeTest
    public void set() {
        textReader = new TextReader();
    }

    @AfterTest
    public void destr() {
        textReader = null;
    }

    @Test (expectedExceptions = IncorrectFileException.class)
    public void fileNotExistTest() throws IncorrectFileException {
        String filename = "thisFileNotExist.txt";
        textReader.readFile(filename);
    }

    @Test
    public void readFileTest() throws IncorrectFileException {
        String filename = "in/testFileForReader.txt";
        String result = textReader.readFile(filename);
        String expected = "\tIt's a test file for reader.\n\tBye.\n";
        Assert.assertEquals(result, expected);
    }
}
