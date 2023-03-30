package java.lang;

import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;

import sun.security.util.SecurityConstants;

public class SecurityManager {

    public void checkPermission(Permission perm) {
        java.security.AccessController.checkPermission(perm);
    }

    public void checkPropertiesAccess() {
        checkPermission(new PropertyPermission("*", SecurityConstants.PROPERTY_RW_ACTION));
    }

    private static boolean packageAccessValid = false;

    private static String[] packageAccess;

    private static final Object packageAccessLock = new Object();

    public void checkPackageAccess(String pkg) {
        if (pkg == null) {
            throw new NullPointerException("package name can't be null");
        }

        String[] pkgs;
        synchronized (packageAccessLock) {
            if (!packageAccessValid) {
                String tmpPropertyStr = AccessController.doPrivileged(
                        new PrivilegedAction<String>() {
                            @Override
                            public String run() {
                                return java.security.Security.getProperty(
                                        "package.access"
                                );
                            }
                        }
                );
                packageAccess = getPackages(tmpPropertyStr);
                packageAccessValid = true;
            }

            pkgs = packageAccess;
        }

        for (int i = 0; i < pkgs.length; i++) {
            if (pkg.startsWith(pkgs[i]) || pkgs[i].equals(pkg + ".")) {
                checkPermission(
                        new RuntimePermission("accessClassInPackage." + pkg));
                break;
            }
        }
    }
}
