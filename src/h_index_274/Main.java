package h_index_274;

public class Main {
    public static void main(String[] args) {

        System.out.println(hIndex(new int[]{3, 0, 1, 5, 6}));

    }

    public static int hIndex(int[] citations) {

        int[] bucket = new int[citations.length + 1];

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length)
                bucket[citations.length]++;
            else bucket[citations[i]]++;
        }

        int index = 0;

        for (int i = citations.length; i >= 0; i--) {
            index += bucket[i];
            if (i <= index) return i;
        }
        return 0;
    }

}
