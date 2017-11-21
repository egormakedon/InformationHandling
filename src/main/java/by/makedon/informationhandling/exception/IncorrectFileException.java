package by.makedon.informationhandling.exception;

public class IncorrectFileException extends Exception {
    public IncorrectFileException() {}
    public IncorrectFileException(String m) {
        super(m);
    }
    public IncorrectFileException(Throwable e) {
        super(e);
    }
    public IncorrectFileException(String m, Throwable e) {
        super(m, e);
    }
}