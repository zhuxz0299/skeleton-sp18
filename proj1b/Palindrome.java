public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charDeque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++)
            charDeque.addLast(word.charAt(i));
        return charDeque;
    }
}