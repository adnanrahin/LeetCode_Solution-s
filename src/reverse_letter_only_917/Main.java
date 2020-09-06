package reverse_letter_only_917;

public class Main {

    public static void main(String[] args) {

    }

    public static String reverseOnlyLetters(String S) {

        char[] solution = S.toCharArray();

        int left = 0;
        int right = solution.length - 1;

        while (left < right) {
            if (Character.isLetter(solution[left]) && Character.isLetter(solution[right])) {
                char temp = solution[left];
                solution[left] = solution[right];
                solution[right] = temp;
                left++;
                right--;
            } else if (!Character.isLetter(solution[left]) && !Character.isLetter(solution[right])) {
                left++;
                right--;
            } else if (!Character.isLetter(solution[left])) left++;
            else if (!Character.isLetter(solution[right])) right--;
        }
        return new String(solution);
    }

}
