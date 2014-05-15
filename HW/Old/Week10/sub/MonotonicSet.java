public interface MonotonicSet<E> extends Iterable<E> {

    void add(E element);
    int size();
}