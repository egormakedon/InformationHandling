package by.makedon.informationhandling.exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException() {}
    public InvalidArgumentException(String m) {
        super(m);
    }
    public InvalidArgumentException(String m, Throwable th)  {
        super(m, th);
    }
    public InvalidArgumentException(Throwable th) {
        super(th);
    }
}
