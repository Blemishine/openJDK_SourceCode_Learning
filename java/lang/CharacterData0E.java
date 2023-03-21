package java.lang;

public class CharacterData0E extends CharacterData {

    int getProperties(int ch) {
        char offset = (char) ch;
        int props = A[Y[X[offset>>5]|((offset>>1)&0xF)]|(offset&0x1)];
        return props;
    }

    int toLowerCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00020000) != 0) {
            int offset = val << 5 >> (5 + 18);
            mapChar = ch + offset;
        }
        return mapChar;
    }

    int toUpperCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00010000) != 0) {
            int offset = val << 5 >> (5 + 18);
            mapChar = ch - offset;
        }
        return mapChar;
    }

    static CharacterData0E instance = new CharacterData0E();

    static final char X[] = (
            "\000\020\020\020\040\040\040\040\060\060\060\060\060\060\060\100\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
                    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040").toCharArray();

    static final char Y[] = (
            "\000\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\004\004\004"+
                    "\004\004\004\004\004\004\004\004\004\004\004\004\004\002\002\002\002\002\002"+
                    "\002\002\002\002\002\002\002\002\002\002\006\006\006\006\006\006\006\006\006"+
                    "\006\006\006\006\006\006\006\006\006\006\006\006\006\006\006\002\002\002\002"+
                    "\002\002\002\002").toCharArray();

    static final int A[] = new int[8];
    static final String A_DATA =
            "\u7800\000\u4800\u1010\u7800\000\u7800\000\u4800\u1010\u4800\u1010\u4000\u3006"+
                    "\u4000\u3006";

    static final char B[] = (
            "\000\000\000\000\000\000\000\000").toCharArray();

    static {
        {
            char[] data = A_DATA.toCharArray();
            assert (data.length == (8 * 2));
            int i = 0, j = 0;
            while (i < (8 * 2)) {
                int entry = data[i++] << 16;
                A[j++] = entry | data[i++];
            }
        }
    }
}

