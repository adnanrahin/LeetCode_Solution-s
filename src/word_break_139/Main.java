package word_break_139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String args[]) {

        String s = "aaaaaaa";
        List<String> list = Arrays.asList("aaaa", "aaa");

        System.out.println(wordBreak(s, list));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>();

        for (String word : wordDict)
            dictionary.add(word);

        boolean dp[] = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= s.length(); j++) {
                    if (dictionary.contains(s.substring(i, j))) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }

}
