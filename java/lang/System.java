package java.lang;

public final class System {

    private static native void registerNatives();

    static {
        registerNatives();
    }

    public static native void arraycopy(Object src, int srcPos, Object des, int destPos, int length);

    public static native long nanoTime();
}
