public class ArrayDeque<T> {
    private T[] items;
    private int start, end;
    private int arrayLen;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        arrayLen = 8;
        start = 0;
        end = 1;
    }

    /**
     * use when start == end
     */
    private void doubleArraySize() {
        T[] newArray = (T[]) new Object[arrayLen * 2];
        for (int i = 1; i < arrayLen; i++) {
            newArray[i] = items[(start + i) % arrayLen];
        }
        items = newArray;
        start = 0;
        end = arrayLen;
        arrayLen *= 2;
    }

    /**
     * use when size() * 4 < arrayLen;
     */
    private void halveArraySize() {
        T[] newArray = (T[]) new Object[arrayLen / 2];
        for (int i = (start + 1) % arrayLen, j = 1; i != end; i = (i + 1) % arrayLen, j++) {
            newArray[j] = items[i];
        }
        items = newArray;
        end = size() + 1;
        start = 0;
        arrayLen /= 2;
    }

    public void addFirst(T item) {
        items[start] = item;
        start = (start + arrayLen - 1) % arrayLen;
        if (start == end) {
            doubleArraySize();
        }
    }

    public void addLast(T item) {
        items[end] = item;
        end = (end + 1) % arrayLen;
        if (start == end) {
            doubleArraySize();
        }
    }

    public boolean isEmpty() {
        return (end == (start + 1) % arrayLen);
    }

    public int size() {
        return (end + arrayLen - start - 1) % arrayLen;
    }

    public void printDeque() {
        for (int i = (start + 1) % arrayLen; i != end; i = (i + 1) % arrayLen) {
            System.out.print(items[i] + " ");
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        if (size() == 0) {
            return null;
        }
        T firstItem = items[(start + 1) % arrayLen];
        start = (start + 1) % arrayLen;
        if (arrayLen >= 16 && size() * 4 < arrayLen) {
            halveArraySize();
        }
        return firstItem;
    }

    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        T lastItem = items[(end + arrayLen - 1) % arrayLen];
        end = (end + arrayLen - 1) % arrayLen;
        if (arrayLen >= 16 && size() * 4 < arrayLen) {
            halveArraySize();
        }
        return lastItem;
    }

    public T get(int index) {
        return items[(start + 1 + index) % arrayLen];
    }
}
