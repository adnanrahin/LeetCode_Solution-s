package word_break_II_140;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return backTrack(s, wordDict, new HashMap<String, List<String>>());
    }

    public static List<String> backTrack(String s, List<String> wordDict, Map<String, List<String>> map) {

        if (map.containsKey(s)) return map.get(s);

        List<String> solution = new ArrayList<>();
        if (s.length() == 0) {
            solution.add("");
            return solution;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String restOfTheString = s.substring(word.length());
                List<String> allSubstring = backTrack(restOfTheString, wordDict, map);
                for (String str : allSubstring) {
                    String space = str.length() == 0 ? "" : " ";
                    solution.add(word + space + str);
                }
            }
        }
        map.put(s, solution);
        return solution;

    }

}
