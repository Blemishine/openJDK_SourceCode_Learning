package java.lang;

import java.io.IOException;
import java.io.Serializable;

public class StringBuilder extends AbstractStringBuilder implements Serializable, CharSequence {

    static final long serialVersionUID = 4383685877147921099L;

    public StringBuilder() {
        super(16);
    }

    public StringBuilder(int capacity) {
        super(capacity);
    }

    public StringBuilder(String str) {
        super(str.length() + 16);
        append(str);
    }

    public StringBuilder(CharSequence seq) {
        this(seq.length() + 16);
        append(seq);
    }

    @Override
    public AbstractStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    @Override
    public AbstractStringBuilder append(String str) {
        super.append(str);
        return this;
    }

    @Override
    public StringBuilder append(CharSequence s) {
        super.append(s);
        return this;
    }
}
