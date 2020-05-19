package find_all_anagrams_in_a_string_438;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> solution = new ArrayList<>();

        int pattern[] = new int[26];
        int text[] = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pattern[p.charAt(i) - 'a']++;
            text[s.charAt(i) - 'a']++;
        }

        for (int i = p.length(); i < s.length(); i++) {
            if (arrayCheck(text, pattern)) {
                solution.add(i - p.length());
            }
            text[s.charAt(i) - 'a']++;
            text[s.charAt(i - p.length()) - 'a']--;
        }
        if (arrayCheck(text, pattern))
            solution.add(s.length() - p.length());

        return solution;
    }

    public static boolean arrayCheck(int arr[], int brr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != brr[i]) {
                return false;
            }
        }
        return true;
    }
}
