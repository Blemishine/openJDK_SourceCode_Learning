package java.lang;

import java.util.Collections;
import java.util.Set;

public class ClassLoader {

    private static native void registerNatives();

    static {
        registerNatives();
    }

    private final ClassLoader parent;

    private static class ParallelLoaders {
        private ParallelLoaders() {}

        private static final Set<Class<? extends ClassLoader>> loaderType =
                Collections.newSetFromMap(

                )
    }
}
