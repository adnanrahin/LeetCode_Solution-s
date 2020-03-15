package design_a_stack_with_increment_operation_1381;

public class Main {

    class CustomStack {

        int pointer = 0;
        int arr[];
        int size = 0;

        public CustomStack(int maxSize) {
            this.arr = new int[maxSize];
            size = maxSize;
        }

        public void push(int x) {
            if (size > pointer) {
                arr[pointer] = x;
                pointer++;
            }
        }

        public int pop() {
            if (pointer == 0)
                return -1;
            pointer--;
            return arr[pointer];
        }

        public void increment(int k, int val) {
            int size = Math.min(k, pointer);
            for (int i = 0; i < size; i++)
                arr[i] += val;
        }

    }


}
