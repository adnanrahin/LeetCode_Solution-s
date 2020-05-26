package stream_of_characters_1032;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});

        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));

    }

}

class StreamChecker {

    public class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEndOfTheWord;

        TrieNode() {
            map = new HashMap<>();
            isEndOfTheWord = false;
        }
    }

    private void add(String word) {
        TrieNode current = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            TrieNode node = current.map.get(word.charAt(i));
            if (node == null) {
                node = new TrieNode();
                current.map.put(word.charAt(i), node);
            }
            current = node;
        }
        current.isEndOfTheWord = true;
    }

    private final TrieNode root;
    private List<Character> queryCharacter;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        queryCharacter = new ArrayList<>();
        for (String word : words)
            add(word);
    }

    public boolean query(char letter) {
        queryCharacter.add(letter);
        TrieNode current = root;

        for (int i = queryCharacter.size() - 1; i >= 0; i--) {
            TrieNode node = current.map.get(queryCharacter.get(i));
            current = node;
            if (node == null) return false;
            if (current.isEndOfTheWord) return true;
        }
        return current.isEndOfTheWord;
    }


}