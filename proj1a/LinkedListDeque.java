public class LinkedListDeque<T> {
    private class IntNode {
        T value;
        IntNode prev, next;

        public IntNode() {
            prev = null;
            next = null;
        }

        public IntNode(T v, IntNode p, IntNode n) {
            value = v;
            prev = p;
            next = n;
        }
    }

    private int size;
    private final IntNode sentinal;

    public LinkedListDeque() {
        size = 0;
        sentinal = new IntNode();
        sentinal.prev = sentinal;
        sentinal.next = sentinal;
    }

    public void addFirst(T item) {
        size++;
        IntNode tmp = new IntNode(item, sentinal, sentinal.next);
        sentinal.next.prev = tmp;
        sentinal.next = tmp;
    }

    public void addLast(T item) {
        size++;
        IntNode tmp = new IntNode(item, sentinal.prev, sentinal);
        sentinal.prev.next = tmp;
        sentinal.prev = tmp;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentinal.next;
        while (p != sentinal) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        T item = sentinal.next.value;
        IntNode newFirst = sentinal.next.next;
        sentinal.next = newFirst;
        newFirst.prev = sentinal;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        T item = sentinal.prev.value;
        IntNode newLast = sentinal.prev.prev;
        sentinal.prev = newLast;
        newLast.next = sentinal;
        return item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode p = sentinal.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.value;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursive(index, sentinal.next);
    }

    private T getRecursive(int index, IntNode p) {
        if (index == 0) {
            return p.value;
        }
        return getRecursive(index - 1, p.next);
    }
}
