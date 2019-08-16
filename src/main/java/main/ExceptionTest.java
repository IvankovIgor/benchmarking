package main;

public class ExceptionTest {

    public static class NoStackTraceException extends RuntimeException {

        public NoStackTraceException () {
            super(null, null, false, false);
        }
    }

    private final NoStackTraceException noStackTraceException = new NoStackTraceException();

    public String throwNewException() {
        try {
            throw new NoStackTraceException();
        } catch (NoStackTraceException e) {
            return e.getMessage();
        }
    }

    public String throwPrivateException() {
        try {
            throw noStackTraceException;
        } catch (NoStackTraceException e) {
            return e.getMessage();
        }
    }
}
