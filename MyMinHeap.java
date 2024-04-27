public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void insert(T element) {
        list.add(element);
        heapifyUp(list.size() - 1);
    }

    public T deleteMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        T min = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!isEmpty()) {
            list.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < list.size() && list.get(leftChildIndex).compareTo(list.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
