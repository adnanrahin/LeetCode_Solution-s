package add_binary_67;

public class Main {
    public static void main(String[] args) {

        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "1"));

        System.out.println(addBinary("100111010101010110001010101010010100010001011",
                "101010101010101010101010111110110110110110101101101101011011011010110110110101101101100000000000000001111111111111111111111111000101011010110110110101101101101101101"));

    }

    public static String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder stringBuilder = new StringBuilder();

        char carry = '0';

        while (i >= 0 && j >= 0) {
            if (carry == '1' && a.charAt(i) == '1' && b.charAt(j) == '1') {
                stringBuilder.append("1");
            } else if ((a.charAt(i) == '1' && b.charAt(j) == '1') ||
                    (a.charAt(i) == '1' && carry == '1') || (carry == '1' && b.charAt(j) == '1')) {
                carry = '1';
                stringBuilder.append("0");
            } else {
                char in = a.charAt(i) == '1' || b.charAt(j) == '1' || carry == '1' ? '1' : '0';
                stringBuilder.append(in);
                carry = '0';
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (carry == '1' && a.charAt(i) == '1') {
                stringBuilder.append("0");
            } else {
                char in = a.charAt(i) == '1' || carry == '1' ? '1' : '0';
                stringBuilder.append(in);
                carry = '0';
            }
            i--;
        }

        while (j >= 0) {
            if (carry == '1' && b.charAt(j) == '1') {
                stringBuilder.append("0");
            } else {
                char in = b.charAt(j) == '1' || carry == '1' ? '1' : '0';
                stringBuilder.append(in);
                carry = '0';
            }
            j--;
        }

        if (carry == '1') stringBuilder.append(carry);

        return stringBuilder.reverse().toString();

    }

}
