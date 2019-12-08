package subtract_the_product_and_sum_of_digits_of_an_intger_1281;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int subtractProductAndSum(int n) {
        int ans = 0;

        List<Integer> lst = arInteger(n);

        int mul = 1;
        int sum = 0;

        for(int i = 0; i < lst.size(); i++){
            mul = mul * lst.get(i);
            sum = sum + lst.get(i);

        }

        ans = mul - sum;

        return ans;
    }

    public static List<Integer> arInteger(int number) {


        List<Integer> arrlist = new ArrayList<>();

        int temp = number;

        while(temp != 0){

            int mod = temp % 10;
            temp = temp / 10;
            arrlist.add(mod);
        }

        return arrlist;

    }

}
