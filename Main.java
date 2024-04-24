import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Testing MyArrayList
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(1, 7);
        System.out.println("MyArrayList: " + arrayList.get(1)); // Should print 7

        // Testing MyLinkedList
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add(1, "Java");
        System.out.println("MyLinkedList: " + linkedList.get(1)); // Should print Java

        // Testing MyStack
        MyStack<Character> stack = new MyStack<>();
        stack.push('a');
        stack.push('b');
        System.out.println("MyStack top: " + stack.peek()); // Should print b

        // Testing MyQueue
        MyQueue<Double> queue = new MyQueue<>();
        queue.offer(3.14);
        queue.offer(2.71);
        System.out.println("MyQueue front: " + queue.peek()); // Should print 3.14

        // Testing MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(10);
        minHeap.insert(5);
        System.out.println("MyMinHeap min: " + minHeap.deleteMin()); // Should print 5
    }
}