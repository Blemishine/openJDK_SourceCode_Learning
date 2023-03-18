package java.lang;

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
