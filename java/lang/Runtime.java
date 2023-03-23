package java.lang;

public class Runtime {

    private static Runtime currentRuntime = new Runtime();

    public static Runtime getRuntime() {
        return currentRuntime;
    }

    private Runtime() {}

    public native int availableProcessors();
}
