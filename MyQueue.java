import java.util.NoSuchElementException;

public class MyQueue<E> {
    private MyLinkedList<E> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void offer(E element) {
        list.add(element);
    }

    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.remove(0);
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.get(0); //  gets the element in the front of the queue
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
