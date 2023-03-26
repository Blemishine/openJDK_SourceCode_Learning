package sun.reflect.generics.repository;

import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.tree.Tree;

public abstract class AbstractRepository<T extends Tree> {

    private final GenericsFactory factory;

    private final T tree;

    private GenericsFactory getFactory() {
        return factory;
    }

    protected T getTree() {
        return tree;
    }




}
