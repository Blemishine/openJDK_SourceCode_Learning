package java.security;

import java.util.Properties;

public final class Security {

    private static Properties props;

    public static String getProperty(String key) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new SecurityPermission("getProperty." + key));
        }
        String name = props.getProperty(key);
        if (name != null) {
            name = name.trim();
        }
        return name;
    }
}
