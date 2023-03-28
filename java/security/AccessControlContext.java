package java.security;

public class AccessControlContext {

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
