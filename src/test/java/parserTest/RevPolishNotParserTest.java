package parserTest;

import by.makedon.informationhandling.parser.ReversePolishNotationParser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RevPolishNotParserTest {
    private ReversePolishNotationParser parser;

    @BeforeTest
    public void init() {
        parser = new ReversePolishNotationParser();
    }

    @AfterTest
    public void destr() {
        parser = null;
    }

    @Test
    public void replaceIncrementDecrementIJTest() {
        String expression = "--j + i++ +2+3*1- --j";
        String result = parser.replaceIncrementDecrementIJ(expression, -10, 4);
        String expected = "3+-9+2+3*1-3";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void replaceNegativeNumbersTest() {
        String result = parser.replaceNegativeNumbers("2--1+3+-9+2+3*1-3");
        String exprected = "2-0-1+3+0-9+2+3*1-3";
        Assert.assertEquals(result, exprected);
    }

    @Test
    public void reversePolishNotationParseTest() {
        String expression = "--j + i++ +2+3*1- --j";
        String result = parser.parse(expression, -10, 4);
        String expected = "3 0 + 9 - 2 + 3 1 * + 3 -";
        Assert.assertEquals(result, expected);
    }
}
