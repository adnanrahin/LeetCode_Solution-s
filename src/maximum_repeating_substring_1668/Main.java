package maximum_repeating_substring_1668;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(piTable("aafdfdab a aaab aaab a aaab a aaab a aaab a aaaba", "aaaba")));

    }

    public static int maxRepeating(String sequence, String word) {

        int[] pi = piTable(sequence, word);
        int counter = 0;
        for (int i = word.length(); i < pi.length; i++) {
            if (pi[i] == word.length()) counter++;
        }
        return counter;
    }

    public static int[] piTable(String text, String pattern) {
        String str = pattern + "#" + text;
        int[] pi = new int[str.length()];
        int i = 0, j = 1;

        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = pi[i - 1];
                } else {
                    pi[j] = 0;
                    j++;
                }
            }
        }
        return pi;
    }

}
