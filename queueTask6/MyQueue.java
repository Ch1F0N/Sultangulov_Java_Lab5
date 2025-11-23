package queueTask6;

import java.util.*;

public class MyQueue<T> {  // <-- добавляем <T>
    private java.util.Queue<T> internalQueue = new LinkedList<>();

    public void add(T element) {
        internalQueue.add(element);
    }

    public T poll() {
        return internalQueue.poll();
    }

    public boolean isEmpty() {
        return internalQueue.isEmpty();
    }

    public List<T> toReversedList() {
        List<T> reversed = new ArrayList<>(internalQueue);
        Collections.reverse(reversed);
        return reversed;
    }
}
