package min_stack_155;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

    }

}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {

        stack = new Stack<>();
        min = new Stack<>();

    }

    public void push(int x) {

        if (stack.isEmpty() && min.isEmpty()) {
            stack.push(x);
            min.push(x);
            return;
        } else {
            stack.push(x);
            min.push(Math.min(min.peek(), x));
        }
    }

    public void pop() {

        min.pop();
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
