package by.makedon.informationhandling.exception;

public class FatalArgumentException extends RuntimeException {
    public FatalArgumentException() {}
    public FatalArgumentException(String m) {
        super(m);
    }
    public FatalArgumentException(String m, Throwable e)  {
        super(m, e);
    }
    public FatalArgumentException(Throwable e) {
        super(e);
    }
}