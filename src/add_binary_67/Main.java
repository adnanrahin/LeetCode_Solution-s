package add_binary_67;

public class Main {
    public static void main(String[] args) {

        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "1"));

        System.out.println(addBinary("100111010101010110001010101010010100010001011",
                "10101010101010101010101011111011011011011010110110110101101101101011011011010110110110000000000000000" +
                        "1111111111111111111111111000101011010110110110101101101101101101"));

    }

    public static String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();

        int sum = 0;

        while (i >= 0 || j >= 0) {
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            sum /= 2;
        }

        if (sum >= 1) sb.append(sum);

        return sb.reverse().toString();

    }

}
