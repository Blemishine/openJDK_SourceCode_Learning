package java.security;

import sun.reflect.CallerSensitive;

public class AccessController {

    private AccessController() {}

    @CallerSensitive
    public static native <T> T doPrivileged(PrivilegedAction<T> action);

    public static void checkPermission(Permission perm) throws AccessControlException {

        if (perm == null) {
            throw new NullPointerException("Permission can't be null");
        }

        AccessControlContext stack = getStackAccessControlContext();
    }
}
