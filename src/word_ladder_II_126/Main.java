package word_ladder_II_126;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(findLadders("a", "c", Arrays.asList("a", "b", "c")));
        System.out.println(findLadders("hot", "cog", Arrays.asList("hot", "dog")));
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> solution = new ArrayList<>();
        Map<String, List<String>> graph = breadthFirstSearch(beginWord, wordList);
        depthFirstSearch(beginWord, endWord, graph, new ArrayList<>(), solution);
        return solution;
    }

    public static void depthFirstSearch(String beginWord, String endWord, Map<String, List<String>> graph, List<String> local,
                                        List<List<String>> solution) {

        if (beginWord.equals(endWord)) {
            solution.add(new ArrayList<>(local));
            return;
        }
        if (local.size() == 0) {
            local.add(beginWord);
        }
        for (String word : graph.get(beginWord)) {
            local.add(word);
            depthFirstSearch(word, endWord, graph, local, solution);
            local.remove(local.size() - 1);
        }
    }

    public static Map<String, List<String>> breadthFirstSearch(String beginWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        visited.add(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            char[] parent = queue.poll().toCharArray();
            String parentString = new String(parent);
            graph.put(parentString, new ArrayList<>());
            for (int i = 0; i < parent.length; i++) {
                char temp = parent[i];
                for (char a = 'a'; a <= 'z'; a++) {
                    parent[i] = a;
                    String child = new String(parent);
                    if (!set.contains(child) || child.equals(parentString)) continue;
                    else if (visited.contains(child)) {
                        if (distance.get(child) <= distance.get(parentString)) continue;
                        else graph.get(parentString).add(child);
                    } else {
                        visited.add(child);
                        graph.get(parentString).add(child);
                        queue.add(child);
                        distance.put(child, distance.getOrDefault(parentString, 0) + 1);
                    }
                }
                parent[i] = temp;
            }
        }

        System.out.println(distance);

        return graph;
    }


}
