package sun.reflect.generics.tree;

import sun.reflect.generics.visitor.TypeTreeVisitor;

public class FormalTypeParameter implements TypeTree {

    private final String name;

    private final FieldTypeSignature[] bounds;

    private FormalTypeParameter(String n, FieldTypeSignature[] bs) {
        name = n;
        bounds = bs;
    }

    public static FormalTypeParameter make(String n, FieldTypeSignature[] bs) {
        return new FormalTypeParameter(n, bs);
    }

    public FieldTypeSignature[] getBounds() {
        return bounds;
    }

    public String getName() {
        return name;
    }

    public void accept(TypeTreeVisitor<?> v) {
        v.visitFormalTypeParameter(this);
    }
}
