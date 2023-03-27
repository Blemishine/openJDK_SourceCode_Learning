package sun.reflect.generics.repository;

import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.tree.Tree;
import sun.reflect.generics.visitor.Reifier;

public abstract class AbstractRepository<T extends Tree> {

    private final GenericsFactory factory;

    private final T tree;

    private GenericsFactory getFactory() {
        return factory;
    }

    protected T getTree() {
        return tree;
    }

    protected Reifier getReifier() {
        return Reifier.make(getFactory());
    }

    protected AbstractRepository(String rawSig, GenericsFactory f) {
        tree = parse(rawSig);
        factory = f;
    }

    protected abstract T parse(String s);

}
