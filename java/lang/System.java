package java.lang;

import java.io.PrintStream;
import java.util.Properties;

public final class System {

    private static volatile SecurityManager security = null;

    private static native void registerNatives();

    static {
        registerNatives();
    }

    public final static PrintStream out = null;

    private static Properties props;

    public static native void arraycopy(Object src, int srcPos, Object des, int destPos, int length);

    public static native long nanoTime();

    public static SecurityManager getSecurityManager() {
        return security;
    }

    public static String getProperty(String key) {
        checkKey(key);
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPropertyAccess(key);
        }

        return props.getProperty(key);
    }

    private static void checkKey(String key) {
        if (key == null) {
            throw new NullPointerException("Key can't be null");
        }
        if (key.equals("")) {
            throw new IllegalArgumentException("Key can't be empty");
        }
    }
}
