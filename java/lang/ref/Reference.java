package java.lang.ref;

public abstract class Reference<T> {

    volatile ReferenceQueue<? super T> queue;

    volatile Reference next;

    private T referent;

    public T get() {
        return this.referent;
    }

    Reference(T referent) {
        this(referent, null);
    }

    Reference(T referent, ReferenceQueue<? super T> queue) {
        this.referent = referent;
        this.queue = (queue == null) ? ReferenceQueue.NULL : queue;
    }
}
