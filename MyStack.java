public class MyStack<E> {
    private MyArrayList<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.remove(list.size() - 1); // removing the last element
    }

    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.get(list.size() - 1); // gets the peek of the stack
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
