package palindrome_partitioning_131;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(partition("abab"));

    }

    static List<List<String>> solution;

    public static List<List<String>> partition(String s) {

        solution = new ArrayList<>();

        backTrack(s, new ArrayList<>());

        return solution;
    }

    public static void backTrack(String str, List<String> local) {

        if (str.length() == 0) {
            solution.add(new ArrayList<>(local));
            return;
        }

        for (int i = 1; i <= str.length(); i++) {
            String palindromeString = str.substring(0, i);
            if (isPalindrome(palindromeString)) {
                local.add(palindromeString);
                backTrack(str.substring(i), local);
                local.remove(local.size() - 1);
            }

        }

    }

    public static boolean isPalindrome(String string) {

        for (int i = 0, j = string.length() - 1; i < j; i++, j--)
            if (string.charAt(i) != string.charAt(j))
                return false;

        return true;
    }

}
