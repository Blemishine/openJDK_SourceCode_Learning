package sun.reflect.generics.tree;

import sun.reflect.generics.visitor.TypeTreeVisitor;

public class VoidDescriptor implements ReturnType {
    private static final VoidDescriptor singleton = new VoidDescriptor();

    private VoidDescriptor(){}

    public static VoidDescriptor make() {return singleton;}



    public void accept(TypeTreeVisitor<?> v){v.visitVoidDescriptor(this);}
}

