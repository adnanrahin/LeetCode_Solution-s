package longest_string_chain_1048;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(longestStrChain(new String[]{}));

    }

    public static int longestStrChain(String[] words) {
        int longestStringChain = 0;
        Set<String> dict = new HashSet<>();
        Arrays.stream(words).forEach(str -> dict.add(str));
        System.out.println(dict);
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            longestStringChain = Math.max(longestStringChain, depthFirstSearch(word, dict, frequencyMap));
        }

        return longestStringChain;
    }

    public static int depthFirstSearch(String src, Set<String> dict, Map<String, Integer> frequencyMap) {
        if (src.length() == 0 || !dict.contains(src)) return 0;
        if (frequencyMap.containsKey(src)) return frequencyMap.get(src);
        int longestStringChain = 0;

        for (int i = 0; i < src.length(); i++) {
            String child = src.substring(0, i) + src.substring(i + 1);
            longestStringChain = Math.max(longestStringChain, 1 + depthFirstSearch(child, dict, frequencyMap));
        }

        frequencyMap.put(src, longestStringChain);
        return longestStringChain;
    }

}
