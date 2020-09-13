package compare_strings_by_frequency_of_the_smallest_character_1170;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        int arr[] = numSmallerByFrequency(
                new String[]{"bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab",
                        "bbabbaabb"},
                new String[]{"aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab",
                        "aa"});

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {

        int arr[] = new int[queries.length];

        List<Integer> qfreq = new ArrayList<Integer>();
        List<Integer> wfreq = new ArrayList<Integer>();

        for (int i = 0; i < queries.length; i++) {
            qfreq.add(smallestCharFrequence(queries[i]));
        }
        for (int i = 0; i < words.length; i++) {
            wfreq.add(smallestCharFrequence(words[i]));
        }

        for (int i = 0; i < qfreq.size(); i++) {
            for (int j = 0; j < wfreq.size(); j++) {

                if (qfreq.get(i) < wfreq.get(j))
                    arr[i]++;
            }
        }

        return arr;
    }

    public static int smallestCharFrequence(String str) {

        int smallestfreq = 0;
        int arr[] = new int[124];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            arr[ch]++;
        }

        for (int i = 97; i < arr.length; i++) {
            if (arr[i] > 0) {
                smallestfreq = arr[i];
                break;
            }
        }

        return smallestfreq;

    }

    public static class BinarySearch {
        public static int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] result = new int[queries.length];

            int[] wordNums = new int[words.length];
            int[] queryNums = new int[queries.length];

            for (int i = 0; i < queries.length; i++)
                queryNums[i] = getSmallerCharFreq(queries[i]); // O(number of Strings * Max Length of Any Given Strings (n * K))
            for (int i = 0; i < words.length; i++)
                wordNums[i] = getSmallerCharFreq(words[i]);  // O(number of Strings * Max Length of Any Given Strings (n * K))

            Arrays.sort(wordNums);      // O(M log M)

            for (int i = 0; i < queryNums.length; i++) {
                result[i] = wordNums.length - findTheInsertIndex(wordNums, queryNums[i]); // O(N log M)
            }

            return result;
        }

        public static int findTheInsertIndex(int[] arr, int target) {
            if (arr[arr.length - 1] <= target) return arr.length;
            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    left = mid + 1;
                }
                if (arr[mid] < target) left = mid + 1;
                else if (arr[mid] > target) right = mid;
            }
            return right;
        }

        public static int getSmallerCharFreq(String str) {
            int[] freq = new int[26];
            for (int i = 0; i < str.length(); i++) {
                freq[str.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) return freq[i];
            }
            return -1;
        }
    }

}
