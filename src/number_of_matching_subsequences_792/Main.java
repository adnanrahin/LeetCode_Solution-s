package number_of_matching_subsequences_792;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(numMatchingSubseq("dashjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }


    public static int numMatchingSubseq(String S, String[] words) {
        int counter = 0;

        Map<String, Boolean> subsequence = new HashMap<>();

        for (String word : words) {
            if (!subsequence.containsKey(word)) {
                subsequence.put(word, isSubsequence(word, S));
            }
            counter += (subsequence.get(word)) ? 1 : 0;
        }

        return counter;
    }

    public static boolean isSubsequence(String pattern, String text) {

        if (pattern.length() > text.length()) return false;
        int i = 0;
        int j = 0;
        while (i < pattern.length() && j < text.length()) {
            if (pattern.charAt(i) == text.charAt(j)) i++;
            j++;
        }
        return i == pattern.length();
    }

}
