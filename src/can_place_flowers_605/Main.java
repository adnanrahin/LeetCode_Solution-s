package can_place_flowers_605;

public class Main {
    public static void main(String[] args) {

        System.out.println(canPlaceFlowers(new int[]{1, 1, 0, 0, 0, 0, 1}, 2));

    }


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 1) continue;
            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else {
                if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

            if (n == 0) return true;
        }


        return n == 0;
    }

}
