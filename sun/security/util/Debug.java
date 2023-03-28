package sun.security.util;

public class Debug {

    private String prefix;

    private static String args;

    public static Debug getInstance(String option) {
        return getInstance(option, option);
    }

    public static Debug getInstance(String option, String prefix)
    {
        if (isOn(option)) {
            Debug d = new Debug();
            d.prefix = prefix;
            return d;
        } else {
            return null;
        }
    }

    public static boolean isOn(String option)
    {
        if (args == null)
            return false;
        else {
            if (args.indexOf("all") != -1)
                return true;
            else
                return (args.indexOf(option) != -1);
        }
    }
}
