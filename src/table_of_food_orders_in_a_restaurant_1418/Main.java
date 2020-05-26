package table_of_food_orders_in_a_restaurant_1418;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> order1 = Arrays.asList("David", "3", "Ceviche");
        List<String> order2 = Arrays.asList("Corina", "10", "Beef Burrito");
        List<String> order3 = Arrays.asList("David", "3", "Fried Chicken");
        List<String> order4 = Arrays.asList("Carla", "5", "Water");
        List<String> order5 = Arrays.asList("Carla", "5", "Ceviche");
        List<String> order6 = Arrays.asList("Rous", "3", "Ceviche");

        List<List<String>> orders = Arrays.asList(order1, order2, order3, order4, order5, order6);

        System.out.println(displayTable(orders));


    }

    public static List<List<String>> displayTable(List<List<String>> orders) {

        Map<String, HashMap<String, Integer>> map = new TreeMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < orders.size(); i++) {
            set.add(orders.get(i).get(2));
            String orderNumber = orders.get(i).get(1);
            if (!map.containsKey(orderNumber)) {
                map.put(orderNumber, new HashMap<>());
            }
            map.get(orderNumber).put(orders.get(i).get(2), map.get(orderNumber).getOrDefault(orders.get(i).get(2), 0) + 1);
        }
        List<String> foods = new ArrayList<>();

        foods.addAll(set);

        Collections.sort(foods);


        List<List<String>> solution = new ArrayList<>();

        for (int i = 0; i <= map.size(); i++)
            solution.add(i, new ArrayList<>());

        solution.get(0).add("Table");

        for (int i = 0; i < foods.size(); i++)
            solution.get(0).add(foods.get(i));

        int j = 1;

        List<Integer> keySet = new ArrayList<>();

        for (String key : map.keySet()) keySet.add(Integer.parseInt(key));

        Collections.sort(keySet);

        for (Integer k : keySet) {
            String key = Integer.toString(k);
            Map<String, Integer> table = map.get(key);
            solution.get(j).add(key);
            for (int i = 0; i < foods.size(); i++) {
                if (!table.containsKey(foods.get(i))) solution.get(j).add("0");
                else solution.get(j).add(table.get(foods.get(i)).toString());
            }
            j++;
        }

        return solution;
    }
}
/*
 *
 * [
 * ["David","3","Ceviche"],
 * ["Corina","10","Beef Burrito"],
 * ["David","3","Fried Chicken"],
 * ["Carla","5","Water"],
 * ["Carla","5","Ceviche"],
 * ["Rous","3","Ceviche"]]
 *
 *
 * [
 * ["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],
 * ["3","0","2","1","0"],
 * ["5","0","1","0","1"],
 * ["10","1","0","0","0"]]
 *
 *
 * [["James","12","Fried Chicken"],
 * ["Ratesh","12","Fried Chicken"],
 * ["Amadeus","12","Fried Chicken"],
 * ["Adam","1","Canadian Waffles"],
 * ["Brianna","1","Canadian Waffles"]]
 *
 * */