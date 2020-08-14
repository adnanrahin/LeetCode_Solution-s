package robot_return_tor_origin_657;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(judgeCircle(""));

    }

    public static boolean judgeCircle(String moves) {

        Map<Character, int[]> directions = new HashMap<>();

        directions.put('U', new int[]{-1, 0});
        directions.put('D', new int[]{1, 0});
        directions.put('L', new int[]{0, -1});
        directions.put('R', new int[]{0, 1});


        int[] origin = {0, 0};

        for (int i = 0; i < moves.length(); i++) {
            int[] move = directions.get(moves.charAt(i));
            origin[0] += move[0];
            origin[1] += move[1];
        }

        return origin[0] == 0 && origin[1] == 0;

    }

}
