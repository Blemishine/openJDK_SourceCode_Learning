package sun.security.action;

import java.security.PrivilegedAction;

public class GetPropertyAction implements PrivilegedAction<String> {

    private String theProp;

    private String defaultVal;

    public GetPropertyAction(String theProp) {
        this.theProp = theProp;
    }

    public String run() {
        String value = System.getProperty(theProp);
        return (value == null) ? defaultVal : value;
    }
}
