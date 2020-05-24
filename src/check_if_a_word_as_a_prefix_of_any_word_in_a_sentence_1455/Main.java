package check_if_a_word_as_a_prefix_of_any_word_in_a_sentence_1455;

public class Main {

    public static void main(String args[]) {

        System.out.println(isPrefixOfWord("hello from the other side", "the"));

    }

    public static int isPrefixOfWord(String sentence, String searchWord) {

        int index = -1;

        String[] sentenceArray = sentence.split(" ");

        for (int i = 0; i < sentenceArray.length; i++) {
            if (searchWord.charAt(0) == sentenceArray[i].charAt(0) && searchWord.length() <= sentenceArray[i].length()) {
                if (isPrefix(sentenceArray[i], searchWord))
                    return i + 1;
            }
        }
        return index;
    }

    public static boolean isPrefix(String text, String pat) {
        for (int i = 0; i < pat.length(); i++) {
            if (pat.charAt(i) != text.charAt(i)) return false;
        }
        return true;
    }

}
