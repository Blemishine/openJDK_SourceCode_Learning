package java.io;

public class PrintStream extends FilterOutputStream implements Appendable, Closeable {

    private boolean trouble = false;

    private BufferedWriter textOut;

    private static <T> T requireNonNull(T obj, String message) {
        if (obj == null)
            throw new NullPointerException(message);
        return obj;
    }

    public void print(String s) {
        if (s == null) {
            s = "null";
        }
        write(s);
    }

    public void println(String x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    private void ensureOpen() throws IOException {
        if (out == null) {
            throw new IOException("Stream closed");
        }
    }

    private void write(String s) {
        try {
            synchronized (this) {
                ensureOpen();
                textOut.write(s);
                textOut.flushBuffer();
                textOut.flushBuffer();
                if (autoFlush && (s.indexOf('\n') >= 0)) {
                    out.flush();
                }
            }
        } catch (IOException x) {
            trouble = true;
        }
    }
}
