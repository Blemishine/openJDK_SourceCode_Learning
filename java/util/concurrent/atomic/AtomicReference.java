package java.util.concurrent.atomic;

public class AtomicReference<V> implements java.io.Serializable {

    private static final long serialVersionUID = -1848883965231344442L;

    private volatile V value;

    public AtomicReference(V initialValue) {
        value = initialValue;
    }

    public AtomicReference() {}

    public final V get() {
        return value;
    }
}
