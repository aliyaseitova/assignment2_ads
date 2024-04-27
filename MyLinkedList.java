import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            Node<T> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> previous = getNode(index - 1);
            Node<T> newNode = new Node<>(element);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            T removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        } else {
            Node<T> previous = getNode(index - 1);
            T removedData = previous.next.data;
            previous.next = previous.next.next;
            size--;
            return removedData;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        return getNode(index).data;
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public MyIterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements MyIterator<T> {
        private Node<T> current;

        public LinkedListIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}

