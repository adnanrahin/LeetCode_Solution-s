package maximum_perfromance_of_a_team_1383;

import java.util.*;

public class Main {


    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        Map<Long, Pair> performance = new TreeMap<>();

        for (int i = 0; i < speed.length; i++) {
            performance.put((long) (speed[i] * efficiency[i]), new Pair(speed[i], efficiency[i]));
        }

        List<Long> list = new ArrayList<>();

        for (Map.Entry<Long, Pair> itr : performance.entrySet()) {
            list.add(itr.getKey());
        }

        Collections.sort(list);

        int spd_performance = 0;
        int ef_performance = Integer.MAX_VALUE;

        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            Pair pair = performance.get(list.get(i));
            spd_performance += pair.spd;
            ef_performance = Math.max(ef_performance, pair.ef);
        }

        System.out.println(spd_performance + " " + ef_performance);

        int total = ((spd_performance) * ef_performance) % 1000000007;

        return total;
    }

    public class Pair {
        int spd;
        int ef;

        public Pair(int spd, int ef) {
            this.spd = spd;
            this.ef = ef;
        }
    }
}
