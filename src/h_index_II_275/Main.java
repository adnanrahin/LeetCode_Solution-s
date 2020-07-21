package h_index_II_275;

public class Main {
    public static void main(String[] args) {

    }

    public static int hIndex(int[] citations) {

        int[] bucket = new int[citations.length + 1];

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                bucket[citations.length]++;
            } else bucket[citations[i]]++;
        }

        int counter = 0;

        for (int i = citations.length; i >= 0; i--) {
            counter += bucket[i];
            if (i <= counter) return i;
        }

        return counter;

    }
}
