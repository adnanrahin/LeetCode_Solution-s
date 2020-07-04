package path_crossing_1496;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String args[]) {

        System.out.println(isPathCrossing("SN"));

    }

    public static boolean isPathCrossing(String path) {

        Set<String> set = new HashSet<>();

        int x = 0;
        int y = 0;

        for (int i = 0; i < path.length(); i++) {
            set.add(x + "," + y);
            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'E') {
                x++;
            } else if (path.charAt(i) == 'W') {
                x--;
            }
            if(set.contains(x + "," + y)) return true;
        }

        return false;
    }

}
