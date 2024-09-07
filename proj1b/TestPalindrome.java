import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String pali1 = "oio";
        String pali2 = "i";
        String pali3 = "";
        String pali4 = "slfksaaskfls";
        String pali5 = "AA";
        assertTrue(palindrome.isPalindrome(pali1));
        assertTrue(palindrome.isPalindrome(pali2));
        assertTrue(palindrome.isPalindrome(pali3));
        assertTrue(palindrome.isPalindrome(pali4));
        assertTrue(palindrome.isPalindrome(pali5));
    }

    @Test
    public void testIsPalindrome2() {
        String nonPali1 = "lke";
        String nonPali2 = "persiflage";
        String nonPali3 = "aaaaab";
        assertFalse(palindrome.isPalindrome(nonPali1));
        assertFalse(palindrome.isPalindrome(nonPali2));
        assertFalse(palindrome.isPalindrome(nonPali3));
    }
}
