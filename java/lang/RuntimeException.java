package java.lang;

public class RuntimeException extends Exception {

    static final long serialVersionUID = -7034897190745766939L;

    public RuntimeException() {
        super();
    }

    public RuntimeException(String message) {
        super(message);
    }

    public RuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeException(Throwable cause) {
        super(cause);
    }
}
