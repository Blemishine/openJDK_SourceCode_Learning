package sun.misc;

public class VM {

    private static volatile int finalRefCount = 0;

    private static volatile int peakFinalRefCount = 0;

    public static void addFinalRefCount(int n) {
        finalRefCount += n;
        if (finalRefCount > peakFinalRefCount) {
            peakFinalRefCount = finalRefCount;
        }
    }
}
