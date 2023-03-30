package java.lang;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import sun.reflect.generics.repository.ClassRepository;
import sun.reflect.misc.ReflectionUtil;

import java.lang.reflect.Type;

public class Class<T> implements java.io.Serializable {

    private static final int ANNOTATION = 0x00002000;
    private static final int ENUM = 0x00004000;
    private static final int SYNTHETIC = 0x00001000;

    private static native void registerNatives();

    static {
        registerNatives();
    }

    private Class(ClassLoader loader) {
        classLoader = loader;
    }

    public native boolean isArray();

    ClassLoader getClassLoader0() {
        return classLoader;
    }

    private final ClassLoader classLoader;

    static native Class<?> getPrimitiveClass(String name);

    public String getName() {
        String name = this.name;
        if (name == null) {
            this.name = name = getName0();
        }
        return name;
    }

    public Type[] getGenericInterfaces() {
        ClassRepository info = getGenericInfo();
        return (info == null) ? getInterfaces() : info.getSuperInterfaces();
    }

    private transient String name;
    private native String getName0();

    @CallerSensitive
    public ClassLoader getClassLoader() {
        ClassLoader cl = getClassLoader0();
        if (cl == null) {
            return null;
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            ClassLoader.checkClassLoaderPermission(cl, Reflection.getCallerClass());
        }
        return cl;
    }

    public native Class<?> getComponentType();

    public native Class<? super T> getSuperClass();

    private native Object[] getEnclosingMethod0();

    private EnclosingMethodInfo getEnclosingMethodInfo() {
        Object[] enclosingInfo = getEnclosingMethod0();
        if (enclosingInfo == null) {
            return null;
        } else {
            return new EnclosingMethodInfo(enclosingInfo);
        }
    }

    private final static class EnclosingMethodInfo {
        private Class<?> enclosingClass;
        private String name;
        private String descriptor;

        private EnclosingMethodInfo(Object[] enclosingInfo) {
            if (enclosingInfo.length != 3) {
                throw new InternalError("Malformed enclosing method information");
            }

            try {
                enclosingClass = (Class<?>) enclosingInfo[0];
                assert (enclosingInfo != null);

                name = (String) enclosingInfo[1];
                descriptor = (String) enclosingInfo[2];

                assert ((name != null && descriptor != null) || name == descriptor);
            } catch (ClassCastException cce) {
                throw new InternalError("Invalid type in enclosing method information", cce);
            }
        }

        boolean isPartial() {
            return enclosingClass == null || name == null || descriptor == null;
        }

        boolean isConstructor() {
            return !isPartial() && "<init>".equals(name);
        }

        boolean isMethod() {
            return !isPartial() && !isConstructor() && !"<clinit>".equals(name);
        }

        Class<?> getEnclosingClass() {
            return enclosingClass;
        }

        String getName() {
            return name;
        }

        String getDescriptor() {
            return descriptor;
        }
    }

    @CallerSensitive
    public Class<?> getDeclaringClass() throws SecurityException {
        final Class<?> candidate = getDeclaringClass0();

        if (candidate != null)
            candidate.checkPackageAccess(
                    ClassLoader.getClassLoader(Reflection.getCallerClass()), true);
        return candidate;
    }

    private native Class<?> getDeclaringClass0();

    @CallerSensitive
    public Class<?> getEnclosingClass() throws SecurityException {
        EnclosingMethodInfo enclosingInfo = getEnclosingMethodInfo();
        Class<?> enclosingCandidate;

        if (enclosingInfo == null) {
            enclosingCandidate = getDeclaringClass();
        } else {
            Class<?> enclosingClass = enclosingInfo.getEnclosingClass();
            if (enclosingClass == this || enclosingClass == null) {
                throw new InternalError("Malformed enclosing method information");
            } else {
                enclosingCandidate = enclosingClass;
            }
        }

        if (enclosingCandidate != null) {
            enclosingCandidate.checkPackageAccess(
                    ClassLoader.getClassLoader(Reflection.getCallerClass()), true);
        }

        return enclosingCandidate;
    }

    public String getCanonicalName() {
        if(isArray()) {
            String canonicalName = getComponentType().getCanonicalName();
            if (canonicalName != null) {
                return canonicalName + "[]";
            } else {
                return null;
            }
        }
        if (isLocalOrAnonymousClass()) {
            return null;
        }
        Class<?> enclosingClass = getEnclosingClass();
        if (enclosingClass == null) {
            return getName();
        } else {
            String enclosingName = enclosingClass.getCanonicalName();
            if (enclosingName == null) {
                return null;
            }
            return enclosingName + "." + getSimpleName();
        }
    }

    private boolean isLocalOrAnonymousClass() {
        return getEnclosingMethodInfo() != null;
    }

    private void checkPackageAccess(final ClassLoader ccl, boolean checkProxyInterface) {
        final SecurityManager s = System.getSecurityManager();
        if (s != null) {
            final ClassLoader cl = getClassLoader0();

            if (ReflectionUtil.needsPackageAccessCheck(ccl, cl)) {
                String name = this.getName();
                int i = name.lastIndexOf('.');
                if (i != -1) {
                    String pkg = name.substring(0, i);
                    if (!Proxy.isProxyClass(this) || ReflectionUtil.isNonPublicProxyClass(this)) {
                        s.checkPackageAccess(pkg);
                    }
                }
            }

            if (checkProxyInterface && Proxy.isProxyClass(this)) {
                ReflectionUtil.checkProxyPackageAccess(ccl, this.getInterfaces());
            }
        }
    }
}
