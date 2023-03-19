package java.lang;

import java.util.Arrays;

public final class String implements java.io.Serializable {

    private final char value[];

    private int hash;

    private static final long serialVersionUID = -6849794470754667710L;

    public String() {
        this.value = "".value;
    }

    public String(String original) {
        this.value = original.value;
        this.hash = original.hash;
    }

    public String(char[] value, boolean share) {
        this.value = value;
    }

    public String(char value[]) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public String(char value[], int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count <= 0) {
            if (count < 0) {
                throw new StringIndexOutOfBoundsException(count);
            }
            if (offset <= value.length) {
                this.value = "".value;
                return;
            }
        }

        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }

        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + h + val[i];
            }

            hash = h;
        }
        return h;
    }
}
