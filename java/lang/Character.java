package java.lang;

public final class Character implements java.io.Serializable, Comparable<Character> {

    public static final int MIN_RADIX = 2;

    public static final int MAX_RADIX = 36;

    public static final char MIN_VALUE = '\u0000';

    public static final char MAX_VALUE = '\uFFFF';

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
}
