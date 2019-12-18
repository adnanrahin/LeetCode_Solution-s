package elelment_appearing_more_than_25_percent_in_sorted_array;

import java.util.Hashtable;

public class Main {

    public static void main(String args[]) {

        //System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(findSpecialInteger(new int[]{1, 2, 3, 3}));

    }

    public static int findSpecialInteger(int[] arr) {
        int global = 0;
        int local = 0;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                local++;
                System.out.println(local);
            } else {
                if (local > global) {
                    index = i;
                    global = Math.max(global, local);
                }
                local = 0;
            }

        }

        return arr[index];

    }

}
