package java.io;

public class PrintStream extends FilterOutputStream implements Appendable, Closeable {

    private boolean trouble = false;

    private static <T> T requireNonNull(T obj, String message) {
        if (obj == null)
            throw new NullPointerException(message);
        return obj;
    }

}
