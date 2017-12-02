package by.makedon.informationhandling.calculator;

import by.makedon.informationhandling.interpreter.runner.InterpreterRunner;
import by.makedon.informationhandling.parser.ReversePolishNotationParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpressionCalculator {
    private final static Logger LOGGER = LogManager.getLogger(ExpressionCalculator.class);

    public String calculate(String expression, int i, int j) {
        ReversePolishNotationParser parser = new ReversePolishNotationParser();
        String expAfterParsing = parser.parse(expression, i, j);
        InterpreterRunner interpreterRunner = new InterpreterRunner();
        String resultNumber = interpreterRunner.calculate(expAfterParsing);
        LOGGER.log(Level.INFO, "expression(" + i + "," + j +"): " + expression + " = " + resultNumber);
        return resultNumber;
    }
}