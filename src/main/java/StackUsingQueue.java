import java.util.Objects;

public class StackUsingQueue<E> implements StackADT<E> {
    private final QueueADT<E> q;

    public StackUsingQueue(int capacity) {
        this.q = new ArrayQueue<>(capacity);
    }

    @Override
    public int size() {
        return q.size();
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty();
    }

    @Override
    public E top() {
        return q.first();
    }

    @Override
    public void push(E e) {
        Objects.requireNonNull(e, "Null elements are not supported in this assignment.");

        // Enqueue the new element
        q.enqueue(e);

        // Rotate the queue so the new element moves to the front
        int rotations = q.size() - 1;
        for (int i = 0; i < rotations; i++) {
            q.enqueue(q.dequeue());
        }
    }

    @Override
    public E pop() {
        return q.dequeue();
    }
}
