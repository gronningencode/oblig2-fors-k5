package dat102.f05.stabel.lenketstabel;

import java.util.EmptyStackException;
import dat102.f05.stabel.StabelADT;

public final class LenketStabel<T> implements StabelADT<T> {

    private Node topNode;

    public LenketStabel() {
        topNode = null;
    }

    @Override
    public void push(T newEntry) {
        topNode = new Node(newEntry, topNode);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.data;
    }

    @Override
    public T pop() {
        T top = peek();  // Kaster exception hvis tom
        topNode = topNode.neste;
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }

    // ---------------- Node-klasse ----------------
    private class Node {
        private final T data;
        private final Node neste;

        private Node(T data, Node neste) {
            this.data = data;
            this.neste = neste;
        }
    }
}