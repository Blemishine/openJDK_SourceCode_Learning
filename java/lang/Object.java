package java.lang;

public class Object {

    private static native void registerNatives();

    static {
        registerNatives();
    }

    public final native Class<?> getClass();

    public native int hashCode();

    public boolean equals(Object obj) {
        return (this == obj);
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public final native void wait(long timeout) throws InterruptedException;

    public final native void notifyAll();
}
