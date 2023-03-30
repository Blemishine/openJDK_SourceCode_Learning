package sun.reflect.misc;

public class ReflectionUtil {

    private ReflectionUtil() {}

    private static boolean isAncestor(ClassLoader p, ClassLoader cl) {
        ClassLoader acl = cl;
        do {
            acl = acl.getParent();
            if (p == acl) {
                return true;
            }
        } while (acl != null);
        return false;
    }

    public static boolean needsPackageAccessCheck(ClassLoader from, ClassLoader to) {
        if (from == null || from == to) {
            return false;
        }

        if (to == null) {
            return true;
        }

        return isAncestor(from, to);
    }

    public static void checkPackageAccess(String name) {
        SecurityManager s = System.getSecurityManager();
        if (s != null) {
            String cname = name.replace('/', '.');
            if (cname.startsWith("[")) {
                int b = cname.lastIndexOf(']') + 2;
                if (b > 1 && b < cname.length()) {
                    cname = cname.substring(b);
                }
            }
            int i = cname.lastIndexOf('.');
            if (i != -1) {
                s.checkPackageAccess(cname.substring(0, i));
            }
        }
    }

    public static void checkPackageAccess(Class<?> clazz) {
        checkPackageAccess(clazz.getName());
        if (isNonPublicProxyClass(clazz)) {
            checkProxyPackageAccess(clazz);
        }
    }

    public static void checkProxyPackageAccess(Class<?> clazz) {
        SecurityManager s = System.getSecurityManager();
        if (s != null) {
            if (Proxy.isProxyClass(clazz)) {
                for (Class<?> intf : clazz.getInterfaces()) {
                    checkPackageAccess(intf);
                }
            }
        }
    }

    public static void checkProxyPackageAccess(ClassLoader ccl, Class<?>... interfaces) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            for (Class<?> intf : interfaces) {
                ClassLoader cl = intf.getClassLoader();
                if (needsPackageAccessCheck(ccl, cl)) {
                    checkPackageAccess(intf);
                }
            }
        }
    }

    public static String PROXY_PACKAGE = "com.sun.proxy";

    public static boolean isNonPublicProxyClass(Class<?> cls) {
        String name = cls.getName();
        int i = name.lastIndexOf('.');
        String pkg = (i != -1) ? name.substring(0, i) : "";
        return Proxy.isProxyClass(cls) && pkg.equals(PROXY_PACKAGE);
    }
}
