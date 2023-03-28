package sun.reflect.generics.repository;

import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.tree.ClassSignature;
import sun.reflect.generics.tree.TypeTree;
import sun.reflect.generics.visitor.Reifier;
import sun.reflect.generics.parser.SignatureParser;

import java.lang.reflect.Type;

public class ClassRepository extends GenericDeclRepository<ClassSignature> {

    public static final ClassRepository NONE = ClassRepository.make("Ljava/lang/Object;", null);

    private volatile Type superclass;

    private volatile Type[] superInterfaces;

    private ClassRepository(String rawSig, GenericsFactory f) {
        super(rawSig, f);
    }

    protected ClassSignature parse(String s) {
        return SignatureParser.make().parseClassSig(s);
    }

    public static ClassRepository make(String rawSig, GenericsFactory f) {
        return new ClassRepository(rawSig, f);
    }

    public Type getSuperclass() {
        Type superclass = this.superclass;
        if (superclass == null) {
            Reifier r = getReifier();
            getTree().getSuperclass().accept(r);
            superclass = r.getResult();
            this.superclass = superclass;
        }
        return superclass;
    }

    public Type[] getSuperInterfaces() {
        Type[] superInterfaces = this.superInterfaces;
        if (superInterfaces == null) {
            TypeTree[] ts = getTree().getSuperInterfaces();
            superInterfaces = new Type[ts.length];
            for (int i = 0; i < ts.length; i++) {
                Reifier r = getReifier();
                ts[i].accept(r);
                superInterfaces[i] = r.getResult();
            }
            this.superInterfaces = superInterfaces;
        }
        return superInterfaces.clone();
    }
}
