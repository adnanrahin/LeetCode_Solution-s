package merge_string_alternately_5685;

public class Main {

    public static void main(String[] args) {

        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", ""));

    }

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0, j = 0;

        while (i < Math.min(word1.length(), word2.length())) {
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(j));
            i++;
            j++;
        }

        while(i < word1.length()) stringBuilder.append(word1.charAt(i++));
        while(j < word2.length()) stringBuilder.append(word2.charAt(j++));

        return stringBuilder.toString();
    }

}
