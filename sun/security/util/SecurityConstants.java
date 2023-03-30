package sun.security.util;

public final class SecurityConstants {

    public static final String PROPERTY_RW_ACTION = "read,write";

    private SecurityConstants() {}

    public static final RuntimePermission GET_CLASSLOADER_PERMISSION =
            new RuntimePermission("getClassLoader");


}
