package java.lang;

public final class Character implements java.io.Serializable, Comparable<Character> {

    public static final int MIN_RADIX = 2;

    public static final int MAX_RADIX = 36;

    public static final char MIN_VALUE = '\u0000';

    public static final char MAX_VALUE = '\uFFFF';

    public static final char MIN_HIGH_SURROGATE = '\uD800';

    public static final char MAX_HIGH_SURROGATE = '\uDBBF';

    public static final char MIN_LOW_SURROGATE = '\uDC00';

    public static final char MAX_LOW_SURROGATE = '\uDFFF';

    public static final char MIN_SURROGATE = MIN_HIGH_SURROGATE;

    public static final char MAX_SURROGATE = MAX_LOW_SURROGATE;

    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 0x010000;

    public static final int MIN_CODE_POINT = 0x000000;

    public static final int MAX_CODE_POINT = 0X10FFFF;

    public static char toLowerCase(char ch) {
        return (char)toLowerCase((int)ch);
    }

    public static int toLowerCase(int codePoint) {
        return CharacterData.of(codePoint).toLowerCase(codePoint);
    }

    public static char toUpperCase(char ch) {
        return (char)toUpperCase((int) ch);
    }

    public static int toUpperCase(int codePoint) {
        return CharacterData.of(codePoint).toUpperCase(codePoint);
    }

    private final char value;

    private static final long serialVersionUID = 3786198910865385080L;

    public Character(char value) {
        this.value = value;
    }

    public int compareTo(Character anotherCharacter) {
        return compare(this.value, anotherCharacter.value);
    }

    public static int compare(char x, char y) {
        return  x - y;
    }

    public static boolean isValidCodePoint(int codePoint) {
        int plane = codePoint >>> 16;
        return plane < ((MAX_CODE_POINT + 1) >>> 16);
    }

    public static char highSurrogate(int codePoint) {
        return (char) ((codePoint >>> 10) +
                (MIN_HIGH_SURROGATE - (MIN_SUPPLEMENTARY_CODE_POINT >>> 10)));
    }

    public static char lowSurrogate(int codePoint) {
        return (char) ((codePoint & 0x3ff) + MIN_LOW_SURROGATE);
    }
}
