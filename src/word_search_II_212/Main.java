package word_search_II_212;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(new HashTableSolution().findWords(board, words));

    }


    public static class HashTableSolution {

        public List<String> findWords(char[][] board, String[] words) {

            int row = board.length;
            int col = board[0].length;

            List<String> solution = new ArrayList<>();
            Map<Character, List<int[]>> startPosition = new HashMap<>();

            for (String word : words) {
                startPosition.put(word.charAt(0), new ArrayList<>());
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (startPosition.containsKey(board[i][j])) startPosition.get(board[i][j]).add(new int[]{i, j});
                }
            }

            for (String word : words) {
                List<int[]> getAllPosition = startPosition.get(word.charAt(0));
                for (int[] pos : getAllPosition) {
                    boolean[][] visited = new boolean[row][col];
                    if (exist(board, pos[0], pos[1], word, 0, visited)) {
                        solution.add(word);
                        break;
                    }
                }
            }

            return solution;
        }

        public static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        public static boolean isValid(char[][] board, int row, int col) {
            return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
        }

        public static boolean exist(char[][] board, int row, int col, String word, int len, boolean[][] visited) {
            if (word.length() == len) return true;
            if (!isValid(board, row, col) || board[row][col] == '-' || word.charAt(len) != board[row][col] || visited[row][col])
                return false;

            char temp = board[row][col];
            visited[row][col] = true;

            for (int[] dir : directions) {
                if (exist(board, row + dir[0], col + dir[1], word, len + 1, visited))
                    return true;
            }
            board[row][col] = temp;
            visited[row][col] = false;

            return false;
        }

    }

    public static class TrieSolution {


        public List<String> findWords(char[][] board, String[] words) {
            List<String> solution = new ArrayList<>();
            Trie trie = new Trie();
            Set<String> set = new HashSet<>();

            for (String word : words) {
                set.add(word);
                trie.insert(word);
            }



            return solution;
        }


        public class Trie {

            public class TrieNode {
                Map<Character, TrieNode> map;
                boolean isWord;

                public TrieNode() {
                    this.map = new HashMap<>();
                    this.isWord = false;
                }
            }

            public final TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode current = root;
                for (int i = 0; i < word.length(); i++) {
                    TrieNode newNode = current.map.get(word.charAt(i));
                    if (newNode == null) {
                        newNode = new TrieNode();
                        current.map.put(word.charAt(i), newNode);
                    }
                    current = newNode;
                }
                current.isWord = true;
            }
        }

    }


}
