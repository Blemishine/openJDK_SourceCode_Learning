package java.util;

public abstract class AbstractCollection<E> implements Collection<E> {

    protected AbstractCollection() {}

    public abstract Iterator<E> iterator();

    public abstract int size();

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        Iterator<E> it = iterator();

        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

}
