package by.makedon.informationhandling.reader;

import by.makedon.informationhandling.exception.IncorrectFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TextReader {
    private final static Logger LOGGER = LogManager.getLogger(TextReader.class);

    public String readFile(String filename) throws IncorrectFileException {
        File file = new File(filename);
        if (file.exists()) {
            LOGGER.log(Level.INFO,filename + " has found");
            Scanner scanner = null;
            StringBuilder sb = new StringBuilder();
            try {
                scanner = new Scanner(new File(filename));
                final String TABULATION_REGEXP = "(\\t| {4})";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    Pattern pattern = Pattern.compile(TABULATION_REGEXP);
                    if (!line.equals("")) {
                        if (!pattern.matcher(line).lookingAt()) {
                            line = " " + line;
                        }
                    }
                    sb.append(line);
                }
                String[] paragraphs = sb.toString().split(TABULATION_REGEXP);
                for (int index = 1; index < paragraphs.length; index++) {
                    paragraphs[index] += "\n";
                }
                sb.delete(0, sb.length());
                sb.append(String.join("\t", paragraphs));
            } catch (FileNotFoundException e) {
                LOGGER.log(Level.WARN,"unknown error", e);
            } finally {
                if (scanner != null) scanner.close();
            }
            LOGGER.log(Level.INFO, filename + " has read correctly");
            return sb.toString();
        } else {
            throw new IncorrectFileException(filename + " hasn't found");
        }
    }
}