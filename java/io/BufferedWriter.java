package java.io;

public class BufferedWriter extends Writer {

    private Writer out;

    private char cb[];

    private int nChars, nextChar;

    private static int defaultCharBufferSize = 8192;

    private String lineSeperator;

    public BufferedWriter(Writer out) {
        this(out, defaultCharBufferSize);
    }

    public BufferedWriter(Writer out, int sz) {
        super(out);
        if (sz <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.out = out;
        cb = new char[sz];
        nChars = sz;
        nextChar = 0;

        lineSeperator =
    }
}
