package java.io;

public class FilterOutputStream extends OutputStream {

    protected OutputStream out;

    public FilterOutputStream(OutputStream out) {
        this.out = out;
    }

    public void write(int b) throws IOException {
        out.write(b);
    }

    public void write(byte b[]) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte b[], int off, int len) throws IOException {
        if ((off | len | (b.length - (len + off)) | (off + len)) < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void flush() throws IOException {
        out.flush();
    }

    @SuppressWarnings("try")
    public void close() throws IOException {
        try (OutputStream ostream = out) {
            flush();
        }
    }
}
