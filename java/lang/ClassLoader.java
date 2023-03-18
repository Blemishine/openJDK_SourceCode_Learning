package java.lang;

public class ClassLoader {

    private static native void registerNatives();

    static {
        registerNatives();
    }

    private final ClassLoader parent;
}
