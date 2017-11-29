package by.makedon.informationhandling.exception;

public class UnknownException extends Exception {
    public UnknownException() {}
    public UnknownException(String m) {
        super(m);
    }
    public UnknownException(Throwable th) {
        super(th);
    }
    public UnknownException(String m, Throwable th) {
        super(m, th);
    }
}
