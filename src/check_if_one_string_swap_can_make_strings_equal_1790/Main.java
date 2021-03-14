package check_if_one_string_swap_can_make_strings_equal_1790;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean areAlmostEqual(String s1, String s2) {

        if (s1.equals(s2)) return true;

        if (s1.length() != s2.length()) return false;

        int diff = 0;

        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }

        return diff == 2 && isSyntaxEqual(s1, s2);
    }

    public static boolean isSyntaxEqual(String s1, String s2) {
        int[] freq = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }

}
