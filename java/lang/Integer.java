package java.lang;

import java.lang.annotation.Native;

public final class Integer extends Number implements Comparable<Integer> {

    @Native
    public static final int MIN_VALUE = 0x80000000;

    @Native
    public static final int MAX_VALUE = 0x7fffffff;

    @SuppressWarnings("unchecked")
    public static final Class<Integer> TYPE = (Class<Integer>) Class.getPrimitiveClass("int");

    final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

}
