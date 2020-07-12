package number_of_substring_with_only_1s_1513;

public class Main {
    public static void main(String[] args) {

        System.out.println(numSub("0110111"));

    }

    public static int numSub(String s) {
        long counter = 0;
        long sum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && counter != 0) {
                sum += ((counter * (counter + 1) / 2)) % mod;
                counter = 0;
            } else if (s.charAt(i) == '1') {
                counter++;
            }
        }

        sum += ((counter * (counter + 1) / 2)) % mod;

        return (int) sum % mod;
    }

}
