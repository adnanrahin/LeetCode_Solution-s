package greatest_common_divisor_of_string_1071;

public class Main {

    public static void main(String args[]) {

    }

    public String gcdOfStrings(String str1, String str2) {

        if (!(str1 + str2).equals(str2 + str1))
            return "";

        return str2.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

}
