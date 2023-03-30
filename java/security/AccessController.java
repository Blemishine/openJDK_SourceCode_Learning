package java.security;

import sun.reflect.CallerSensitive;
import sun.security.util.Debug;

public class AccessController {

    private AccessController() {}

    @CallerSensitive
    public static native <T> T doPrivileged(PrivilegedAction<T> action);

    public static void checkPermission(Permission perm) throws AccessControlException {

        if (perm == null) {
            throw new NullPointerException("Permission can't be null");
        }

        AccessControlContext stack = getStackAccessControlContext();

        if (stack == null) {
            Debug debug = AccessControlContext.getDebug();
            boolean dumpDebug = false;
            if (debug != null) {
                dumpDebug = !Debug.isOn("codebase=");
                dumpDebug &= !Debug.isOn("permission=") ||
                        Debug.isOn("permission=" + perm.getClass().getCanoicalName());
            }

            if (dumpDebug && Debug.isOn("stack")) {
                Thread.dumpStack();
            }

            if (dumpDebug && Debug.isOn("domain")) {
                debug.println("domain (context is null)");
            }

            if (dumpDebug) {
                debug.println("access allowed " + perm);
            }
            return;
        }

        AccessControlContext acc = stack.optimize();
        acc.checkPermission(perm);

    }

    public static native AccessControlContext getStackAccessControlContext();
}
