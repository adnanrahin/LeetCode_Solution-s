package elelment_appearing_more_than_25_percent_in_sorted_array;

public class Main {

    public static void main(String args[]) {

        System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(findSpecialInteger(new int[]{1, 2, 3, 3}));
        System.out.println(findSpecialInteger(new int[]{1, 1, 2, 2, 2, 2, 3, 3}));

    }

    public static int findSpecialInteger(int[] arr) {

        int global = 0;
        int local = 0;
        int index = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i - 1] == arr[i]) {
                local++;
            } else {
                if (local > global) {
                    global = local;
                    index = i - 1;
                }
                local = 0;

            }
        }
        return local > global ? arr[arr.length - 1] : arr[index];
    }

}
