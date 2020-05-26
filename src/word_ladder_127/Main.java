package word_ladder_127;

import java.util.*;

public class Main {

    public static void main(String args[]) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ladderLength("a", "c", Arrays.asList("a", "b", "c")));
        System.out.println(ladderLength("hot", "dog", Arrays.asList("hot", "dog", "dot")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        Map<String, List<String>> graph = new HashMap<>();

        set.addAll(wordList);

        if (!set.contains(endWord)) return 0;

        graph.put(beginWord, new ArrayList<>());

        for (String str : set) {
            if (isOkay(beginWord, str)) {
                graph.get(beginWord).add(str);
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (!wordList.get(i).equals(beginWord))
                graph.put(wordList.get(i), new ArrayList<>());
        }


        for (int i = 0; i < wordList.size(); i++) {
            if (!wordList.get(i).equals(endWord) && !wordList.get(i).equals(beginWord)) {
                for (int j = 0; j < wordList.size(); j++) {
                    if (isOkay(wordList.get(i), wordList.get(j)))
                        graph.get(wordList.get(i)).add(wordList.get(j));
                }
            }
        }


        return breadthFirstSearch(graph, beginWord, endWord);
    }

    public static int breadthFirstSearch(Map<String, List<String>> graph, String src, String dst) {

        Set<String> visited = new HashSet<>();
        visited.add(src);
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(src);
        distance.put(src, 1);

        while (!queue.isEmpty()) {

            String key = queue.poll();

            if (dst.equals(key)) return distance.get(key);

            List<String> edges = graph.get(key);

            for (int i = 0; i < edges.size(); i++) {
                if (!visited.contains(edges.get(i))) {
                    visited.add(edges.get(i));
                    distance.put(edges.get(i), distance.getOrDefault(key, 0) + 1);
                    queue.add(edges.get(i));
                }
            }
        }
        return 0;
    }

    public static boolean isOkay(String a, String b) {
        int distance = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) == b.charAt(i)) distance++;

        if (b.length() - distance <= 1) return true;
        return false;
    }

}
