package reorganize_string_767;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String args[]) {

        System.out.println(reorganizeString("vvvlo"));

    }

    public static String reorganizeString(String S) {

        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            charFrequency.put(S.charAt(i), charFrequency.getOrDefault(S.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (Character ch : charFrequency.keySet()) {
            int frequency = charFrequency.get(ch);
            if (frequency > (1 + S.length()) / 2) return "";
            pq.add(new Pair(ch, frequency));
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (pq.size() >= 2) {
            Pair pair1 = pq.poll();
            Pair pair2 = pq.poll();

            stringBuilder.append(pair1.ch);
            stringBuilder.append(pair2.ch);

            if (--pair1.counter > 0) pq.add(new Pair(pair1.ch, pair1.counter));
            if (--pair2.counter > 0) pq.add(new Pair(pair2.ch, pair2.counter));
        }
        if (pq.size() > 0) stringBuilder.append(pq.poll().ch);

        return stringBuilder.toString();

    }

    public static class Pair implements Comparable<Pair> {
        char ch;
        int counter;


        public Pair(char ch, int counter) {
            this.counter = counter;
            this.ch = ch;
        }

        @Override
        public int compareTo(Pair pair) {
            return pair.counter - this.counter;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "ch=" + ch +
                    ", counter=" + counter +
                    '}';
        }
    }

}
