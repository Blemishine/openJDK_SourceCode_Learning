package java.io;

import java.lang.AutoCloseable;

public interface Closeable extends AutoCloseable {

    public void close() throws IOException;
}
