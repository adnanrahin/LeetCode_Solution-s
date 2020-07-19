package asteroid_collision_735;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(asteroidCollision(new int[]{-6, 10, 5, 4, -5, -6, 6})));

    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            if (stack.isEmpty() && asteroid < 0)
                stack.push(asteroid);
            else if (asteroid < 0 && stack.peek() > 0) {
                stack.push(asteroid);
                while (stack.size() > 1 && stack.peek() == asteroid) {
                    int a = stack.pop();
                    int b = stack.pop();

                    if (a < 0 && b < 0) {
                        stack.push(b);
                        stack.push(a);
                        break;
                    } else if (Math.abs(a) > b)
                        stack.push(a);
                    else if (Math.abs(a) == b) break;
                    else {
                        stack.push(b);
                    }
                }
            } else stack.push(asteroid);
        }

        int[] solution = new int[stack.size()];

        int i = stack.size() - 1;

        while (!stack.isEmpty()) {
            solution[i--] = stack.pop();
        }
        return solution;
    }
}
