package gas_station_134;

public class Main {

    public static void main(String args[]) {

    }

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {

            if (gas.length == 0 || cost.length == 0) return -1;

            int total = 0;
            int start = 0;

            int cur = 0;

            for (int i = 0; i < gas.length; i++) {

                cur += gas[i] - cost[i];
                if (cur < 0) {
                    start = i + 1;
                    cur = 0;
                }
                total += gas[i] - cost[i];
            }

            return total >= 0 ? start : -1;

        }
    }

}
