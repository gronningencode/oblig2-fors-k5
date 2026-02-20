package dat102.f05.stabel;

public interface StabelADT<T> {

    void push(T newEntry);

    T pop();

    T peek();

    boolean isEmpty();

    void clear();
}