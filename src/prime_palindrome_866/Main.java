package prime_palindrome_866;

public class Main {

    public static void main(String[] args) {

        System.out.println(primePalindrome(9989900));
        System.out.println(primePalindrome(100030001));
    }

    public static int primePalindrome(int N) {

        while (true) {
            if (isPalindrome(N) && isPrime(N)) return N;
            N++;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }
    }

    public static boolean isPrime(int N) {

        if (N < 2) return false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int n) {
        int sum = 0;
        int rev = n;
        while (rev != 0) {
            sum = sum * 10 + (rev % 10);
            rev /= 10;
        }
        return sum == n;
    }


}
