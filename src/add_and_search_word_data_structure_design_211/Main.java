package add_and_search_word_data_structure_design_211;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

}


class WordDictionary {

    public class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEndOfTheWord;

        public TrieNode() {
            map = new HashMap<>();
            isEndOfTheWord = false;
        }
    }

    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            TrieNode node = current.map.get(word.charAt(i));
            if (node == null) {
                node = new TrieNode();
                current.map.put(word.charAt(i), node);
            }
            current = node;
        }
        current.isEndOfTheWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    public boolean search(TrieNode root, String word, int index) {
        if (index == word.length()) return root.isEndOfTheWord;

        if (word.charAt(index) == '.') {
            for (Character ch : root.map.keySet()) {
                if (search(root.map.get(ch), word, index + 1)) return true;
            }
        } else {
            for (Character ch : root.map.keySet()) {
                if (word.charAt(index) == ch && search(root.map.get(ch), word, index + 1)) return true;
            }
        }
        return false;
    }

}
