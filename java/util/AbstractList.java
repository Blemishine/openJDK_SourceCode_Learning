package java.util;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    protected AbstractList() {}

    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    abstract public E get(int index);

    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    public int indexOf(Object o) {
        ListIterator<E> it = listIterator();
        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return it.previousIndex();
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    return it.previousIndex();
                }
            }
        }

        return -1;
    }


}
