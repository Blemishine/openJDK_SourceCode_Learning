package sun.reflect.generics.tree;

import sun.reflect.generics.visitor.TypeTreeVisitor;

public class CharSignature implements BaseType {
    private static final CharSignature singleton = new CharSignature();

    private CharSignature() {
    }

    public static CharSignature make() {
        return singleton;
    }

    public void accept(TypeTreeVisitor<?> v) {
        v.visitCharSignature(this);
    }
}

