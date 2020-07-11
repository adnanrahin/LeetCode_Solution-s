package substring_with_concatenation_of_all_words_30;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(findSubstring("abcdef", new String[]{"a", "b", "c", "d", "e", "f"}));
        System.out.println(findSubstring("a", new String[]{"a"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {

        if (words.length == 0 || s.length() == 0) return new ArrayList<>();

        int subStringSize = words[0].length() * words.length;

        if (subStringSize > s.length()) return new ArrayList<>();

        List<Integer> solution = new ArrayList<>();

        Set<Integer> getAllPiValue = new HashSet<>();

        for (String word : words) {
            piTableData(word, s, getAllPiValue);
        }

        Map<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++)
            frequency.put(words[i], frequency.getOrDefault(words[i], 0) + 1);


        for (Integer i : getAllPiValue) {

            Map<String, Integer> tempFrequency = new HashMap<>(frequency);

            if (i + subStringSize > s.length()) continue;

            String subString = s.substring(i, i + subStringSize);
            int counter = words.length;

            StringBuilder cmpString = new StringBuilder();
            int j = 0;

            while (j < subString.length()) {
                cmpString.append(subString.charAt(j));
                if (cmpString.length() == words[0].length()) {
                    if (tempFrequency.containsKey(cmpString.toString()) && tempFrequency.get(cmpString.toString()) > 0) {
                        counter--;
                        tempFrequency.put(cmpString.toString(), tempFrequency.get(cmpString.toString()) - 1);
                        cmpString = new StringBuilder();
                    } else break;
                }
                j++;
            }

            if (counter == 0) {
                solution.add(i);
            }

        }


        return solution;
    }

    public static void piTableData(String pattern, String text, Set<Integer> solution) {

        String word = pattern + "#" + text;

        int[] pi = new int[word.length()];
        pi[0] = 0;

        int i = 0;
        int j = 1;

        while (j < word.length()) {
            if (word.charAt(i) == word.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else if (word.charAt(i) != word.charAt(j) && i > 0) {
                i = pi[i - 1];
            } else if (word.charAt(i) != word.charAt(j) && i == 0) {
                pi[j] = 0;
                j++;
            }
        }

        for (int l = pattern.length() - 1; l < pi.length; l++) {
            if (pi[l] == pattern.length())
                solution.add(l - 2 * pattern.length());
        }

    }
}

