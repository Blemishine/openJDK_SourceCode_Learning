package sun.reflect.generics.tree;

import sun.reflect.generics.visitor.Visitor;

public class ClassSignature implements Signature {

    private final FormalTypeParameter[] formalTypeParameters;

    private final ClassTypeSignature superclass;

    private final ClassTypeSignature[] superInterfaces;

    private ClassSignature(FormalTypeParameter[] ftps, ClassTypeSignature sc, ClassTypeSignature[] sis) {
        formalTypeParameters = ftps;
        superclass = sc;
        superInterfaces = sis;
    }

    public static ClassSignature make(FormalTypeParameter[] ftps, ClassTypeSignature sc, ClassTypeSignature[] sis) {
        return new ClassSignature(ftps, sc, sis);
    }

    public FormalTypeParameter[] getFormalTypeParameters() {
        return formalTypeParameters;
    }

    public ClassTypeSignature getSuperclass() {
        return superclass;
    }

    public ClassTypeSignature[] getSuperInterfaces() {
        return superInterfaces;
    }

    public void accept(Visitor<?> v) {
        v.visitClassSignature(this);
    }
}
