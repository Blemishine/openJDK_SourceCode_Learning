package java.lang;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

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
}
