package java.lang;

public class Class<T> implements java.io.Serializable {

    private static final int ANNOTATION = 0x00002000;
    private static final int ENUM = 0x00004000;
    private static final int SYNTHETIC = 0x00001000;

    private static native void registerNatives();

    static {
        registerNatives();
    }

    static native Class<?> getPrimitiveClass(String name);

    public String getName() {
        String name = this.name;
        if (name == null) {
            this.name = name = getName0();
        }
        return name;
    }

    private transient String name;
    private native String getName0();

    public native Class<?> getComponentType();

    public native Class<? super T> getSuperClass();
}
