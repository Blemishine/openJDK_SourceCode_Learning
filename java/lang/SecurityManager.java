package java.lang;

import java.security.Permission;

public class SecurityManager {

    public void checkPermission(Permission perm) {
        java.security.AccessController.checkPermission(perm);
    }

    public void checkPropertiesAccess() {
        checkPermission(new PropertyPermission("*", SecurityConstants.PROPERTY_RW_ACTION));
    }
}
