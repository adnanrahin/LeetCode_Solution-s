package redundant_connection_II_685;

public class Main {

    public static void main(String[] args) {

    }

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int[] redundantConnection = new int[2];
        

        return redundantConnection;

    }

    public static int find(int[] dsu, int x) {
        if (x == dsu[x]) return x;
        return find(dsu, dsu[x]);
    }

    public static void union(int[] dsu, int x, int y) {
        int xp = find(dsu, x);
        int yp = find(dsu, y);
        dsu[yp] = xp;
    }

}
