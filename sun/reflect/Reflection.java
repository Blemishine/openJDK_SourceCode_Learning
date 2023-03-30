package sun.reflect;

public class Reflection {

    @CallerSensitive
    public static native Class<?> getCallerClass();
}
