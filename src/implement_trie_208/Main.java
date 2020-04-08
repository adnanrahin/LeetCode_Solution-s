package implement_trie_208;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
}

class Trie {

    public class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEndOfTheWord;

        TrieNode() {
            map = new HashMap<>();
            isEndOfTheWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

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
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchForNode(word);
        return node != null && node.isEndOfTheWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (searchForNode(prefix) == null) return false;
        return true;
    }

    public TrieNode searchForNode(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            TrieNode node = current.map.get(word.charAt(i));
            if (node == null) return null;
            current = node;
        }
        return current;
    }

}
