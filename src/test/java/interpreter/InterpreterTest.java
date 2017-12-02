package interpreter;

import by.makedon.informationhandling.interpreter.runner.InterpreterRunner;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InterpreterTest {
    private InterpreterRunner interpreter;

    @BeforeTest
    public void init() {
        interpreter = new InterpreterRunner();
    }

    @AfterTest
    public void destr() {
        interpreter = null;
    }

    @Test
    public void calculateTest() {
        String result = interpreter.calculate("3 0 + 9 - 2 + 3 1 * + 3 -");
        String expected = "-4,00";
        Assert.assertEquals(result, expected);
    }
}
