package sun.reflect.generics.tree;

import sun.reflect.generics.visitor.TypeTreeVisitor;

public class SimpleClassTypeSignature implements FieldTypeSignature {

    private final boolean dollar;
    private final String name;
    private final TypeArgument[] typeArgs;

    private SimpleClassTypeSignature(String n, boolean dollar, TypeArgument[] tas) {
        name = n;
        this.dollar = dollar;
        typeArgs = tas;
    }

    public static SimpleClassTypeSignature make (String n, boolean dollar, TypeArgument[] tas) {
        return new SimpleClassTypeSignature(n, dollar, tas);
    }

    public boolean getDollar() {
        return dollar;
    }

    public String getName() {
        return name;
    }

    public TypeArgument[] getTypeArguments() {
        return typeArgs;
    }

    public void accept(TypeTreeVisitor<?> v) {
        v.visitSimpleClassTypeSignature(this);
    }
}
