public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> intArr = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            intArr.addLast(i);
        }
        intArr.printDeque();
        for (int i = 1; i < 10; i++) {
            intArr.addFirst(i);
        }
        intArr.printDeque();
        System.out.println("arr size is " + intArr.size());
        for (int i = 0; i < 19; i++) {
            System.out.print(intArr.removeFirst() + " ");
        }
        System.out.println();
        System.out.println(intArr.isEmpty());

        intArr.removeFirst();
        intArr.removeLast();
        System.out.println(intArr.size());
        System.out.println(intArr.isEmpty());
    }
}
