package sun.reflect.generics.repository;

import sun.reflect.generics.factory.GenericFactory;
import sun.reflect.generics.tree.Tree;

public abstract class AbstractRepository<T extends Tree> {

    private final GenericFactory factory;

    private final T tree;

    private GenericFactory getFactory() {
        return factory;
    }

    protected T getTree() {
        return tree;
    }


}
