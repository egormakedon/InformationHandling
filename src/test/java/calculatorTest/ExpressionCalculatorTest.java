package calculatorTest;

import by.makedon.informationhandling.calculator.ExpressionCalculator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpressionCalculatorTest {
    private ExpressionCalculator calculator;

    @BeforeTest
    public void init() {
        calculator = new ExpressionCalculator();
    }

    @AfterTest
    public void destr() {
        calculator = null;
    }

    @Test
    public void calculateTest() {
        String expression = "(-5*(2+3-(--j +1+2+3))+ ++i)/4";
        String result = calculator.calculate(expression, -2, 5);
        String expected = "6,00";
        Assert.assertEquals(result, expected);
    }
}