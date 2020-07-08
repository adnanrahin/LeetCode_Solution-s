package minimum_genetic_mutation_433;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(minMutation("AACCTTGG", "AATTCCGG",
                new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"}));

        System.out.println(minMutation("AACCGGTT", "AAACGGTA",
                new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));

    }

    public static int minMutation(String start, String end, String[] bank) {

        if (start.length() != end.length() || start.length() == 0 || end.length() == 0) return -1;

        Set<String> set = new HashSet<>();
        set.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        Map<String, Integer> distance = new HashMap<>();

        distance.put(start, 0);

        for (String s : bank)
            distance.put(s, 0);

        while (!queue.isEmpty()) {

            String str = queue.poll();

            for (String s : bank) {
                if (!set.contains(s) && distance(s, str)) {
                    queue.add(s);
                    set.add(s);
                    distance.put(s, distance.get(str) + 1);
                }
            }
        }
        return !distance.containsKey(end) || distance.get(end) == 0 ? -1 : distance.get(end);
    }

    public static boolean distance(String a, String b) {
        int counter = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) counter++;
        }
        return counter == 1;
    }

}
