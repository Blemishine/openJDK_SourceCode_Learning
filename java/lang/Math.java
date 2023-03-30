package java.lang;

public final class Math {

    private Math() {
    }

    private static long negativeZeroFloatBits = Float.floatToRawIntBits(-0.0f);

    public static int min(int a, int b) {
        return (a <= b) ? a : b;
    }

    public static long min(long a, long b) {
        return (a <= b) ? a : b;
    }

    public static float min(float a, float b) {
        if (a != a) {
            return a;
        }

        if ((a == 0.0f) && (b == 0.0f) && (Float.floatToRawIntBits(b) == negativeZeroFloatBits)) {
            return b;
        }

        return (a <= b) ? a : b;
    }

    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    public static long max(long a, long b) {
        return (a >= b) ? a : b;
    }
}
