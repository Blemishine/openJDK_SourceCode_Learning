package java.security;

import sun.security.util.Debug;

public class AccessControlContext {

    private static boolean debugInit = false;

    private static Debug debug = null;

    static Debug getDebug() {
        if (debugInit) {
            return debug;
        } else {
            if (Policy.isSet()) {
                debug = Debug.getInstance("access");
                debugInit = true;
            }
            return debug;
        }
    }
}
