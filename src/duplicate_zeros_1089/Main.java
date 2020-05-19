package duplicate_zeros_1089;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

    }

    public void duplicateZeros(int[] arr) {

        List<Integer> zeros = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                zeros.add(0);
                zeros.add(0);
            } else zeros.add(arr[i]);

        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = zeros.get(i);

    }

}
