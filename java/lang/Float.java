package java.lang;

import sun.misc.FloatConsts;

public class Float extends Number implements Comparable<Float> {

    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;

    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;

    public static final float NaN = 0.0f / 0.0f;

    public static final float MAX_VALUE = 0x1.fffffeP+127f;

    public static final float MIN_NORMAL = 0x1.0p-126f;

    public static final float MIN_VALUE = 0x0.000002P-126f;

    public static final int MAX_EXPONENT = 127;

    public static final int MIN_EXPONENT = -126;

    public static final int SIZE = 32;

    @SuppressWarnings("unchecked")
    public static final Class<Float> TYPE = (Class<Float>) Class.getPrimitiveClass("float");

    public static boolean isNaN(float v) {
        return (v != v);
    }

    private final float value;

    public Float(float value) {
        this.value = value;
    }

    public Float(double value) {
        this.value = (float) value;
    }

    public byte byteValue() {
        return (byte) value;
    }

    public short shortValue() {
        return (short) value;
    }

    public int intValue() {
        return (int) value;
    }

    public long longValue() {
        return (long) value;
    }

    public float floatValue() {
        return value;
    }

    public double doubleValue() {
        return (double) value;
    }

    public int compareTo(Float anotherFloat) {
        return Float.compare(value, anotherFloat.value);
    }

    public static int compare(float f1, float f2) {
        if (f1 < f2) {
            return -1;
        }
        if (f1 > f2) {
            return 1;
        }

        int thisBits = Float.floatToIntBits(f1);
        int anotherBits = Float.floatToIntBits(f2);

        return (thisBits == anotherBits ? 0 :
                (thisBits < anotherBits ? -1 : 1));
    }

    public static int floatToIntBits(float value) {
        int result = floatToRawIntBits(value);
        if (((result & FloatConsts.EXP_BIT_MASK) == FloatConsts.EXP_BIT_MASK) &&
                (result & FloatConsts.SIGNIF_BIT_MASK) != 0) {
            result = 0x7fc00000;
        }
        return result;
    }

    public static native int floatToRawIntBits(float value);

}
