package sun.reflect.generics.repository;

import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.tree.FormalTypeParameter;
import sun.reflect.generics.tree.Signature;
import sun.reflect.generics.visitor.Reifier;

import java.lang.reflect.TypeVariable;

public abstract class GenericDeclRepository<S extends Signature> extends AbstractRepository<S> {

    private volatile TypeVariable<?>[] typeParams;

    protected GenericDeclRepository(String rawSig, GenericsFactory f) {
        super(rawSig, f);
    }

    public TypeVariable<?>[] getTypeParameters() {
        TypeVariable<?>[] typeParams = this.typeParams;
        if (typeParams == null) {
            FormalTypeParameter[] ftps = getTree().getFormalTypeParameters();
            typeParams = new TypeVariable<?>[ftps.length];
            for (int i = 0; i < ftps.length; i++) {
                Reifier r = getReifier();
                ftps[i].accept(r);
                typeParams[i] = (TypeVariable<?>) r.getResult();
            }
            this.typeParams = typeParams;
        }
        return typeParams.clone();
    }
}
