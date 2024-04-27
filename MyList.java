public interface MyList<T> {
    void add(T element);
    void add(int index, T element);
    T get(int index);
    T remove(int index);
    int size();
    boolean isEmpty();
    boolean contains(T element);
    void clear();
    MyIterator<T> iterator();
}