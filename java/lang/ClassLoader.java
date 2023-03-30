package java.lang;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import sun.security.util.SecurityConstants;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ClassLoader {

    private static native void registerNatives();

    static {
        registerNatives();
    }

    private final ClassLoader parent;

    private static class ParallelLoaders {
        private ParallelLoaders() {}

        private static final Set<Class<? extends ClassLoader>> loaderTypes =
                Collections.newSetFromMap(
                    new WeakHashMap<Class<? extends ClassLoader>, Boolean>());

        static {
            synchronized (loaderTypes) {
                loaderTypes.add(ClassLoader.class);
            }
        }

        static boolean register(Class<? extends ClassLoader> c) {
            synchronized (loaderTypes) {
                if (loaderTypes.contains(c.getSuperClass())) {
                    loaderTypes.add(c);
                    return true;
                } else {
                    return false;
                }
            }
        }

        static boolean isRegistered(Class<? extends ClassLoader> c) {
            synchronized (loaderTypes) {
                return loaderTypes.contains(c);
            }
        }
    }

    private final ConcurrentHashMap<String, Object> parallelLockMap;

    static ClassLoader getClassLoader(Class<?> caller) {
        if (caller == null) {
            return null;
        }
        return caller.getClassLoader0();
    }

    @CallerSensitive
    public final ClassLoader getParent() {
        if (parent == null) {
            return null;
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            checkClassLoaderPermission(parent, Reflection.getCallerClass());
        }
        return parent;
    }

    boolean isAncestor(ClassLoader cl) {
        ClassLoader acl = this;
        do {
            acl = acl.parent;
            if (cl == acl) {
                return true;
            }
        } while (acl != null);
        return false;
    }

    private static boolean needsClassLoaderPermissionCheck(ClassLoader from, ClassLoader to) {
        if (from == to)
            return false;

        if (from == null)
            return false;

        return !to.isAncestor(from);
    }

    static void checkClassLoaderPermission(ClassLoader cl, Class<?> caller) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            ClassLoader ccl = getClassLoader(caller);
            if (needsClassLoaderPermissionCheck(ccl, cl)) {
                sm.checkPermission(SecurityConstants.GET_CLASSLOADER_PERMISSION);
            }
        }
    }
}
