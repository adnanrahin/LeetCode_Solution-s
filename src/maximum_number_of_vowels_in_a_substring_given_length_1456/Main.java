package maximum_number_of_vowels_in_a_substring_given_length_1456;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String args[]) {
       
    }

    public static int maxVowels(String s, int k) {

        int maxVowel = 0;

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {

        }

        return maxVowel;

    }

    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }

}
