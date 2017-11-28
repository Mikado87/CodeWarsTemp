import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Mikado on 19.11.2017.
 */
public class DirectionsReduction {

    public static void main(String[] args) {
        dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"});

    }

    public static String[] dirReduc(String[] arr) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new LinkedList<>();

        for (String step : arr) {
            switch(step) {
                case "NORTH":
                    if (list.contains("SOUTH")){
                        list.remove("SOUTH");
                    } else list.add(step);
                    break;
                case "SOUTH":
                    if (list.contains("NORTH")) {
                        list.remove("NORTH");
                    } else list.add(step);
                    break;
                case "EAST":
                    if (list.contains("WEST")) {
                        list.remove("WEST");
                    } else list.add(step);
                    break;
                case "WEST":
                    if (list.contains("EAST")) {
                        list.remove("EAST");
                    } else list.add(step);
                    break;
            }
        }
//        System.out.println("arr = [" + list.toString() + "]");
        String[] array  = new String[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        System.out.println(array.toString());

        for (String step : arr) {
            if (map.containsKey(step)){
                int count = map.get(step);
                map.put(step, ++count);
            } else {
                map.put(step, 1);
            }

            switch (step) {
                case "NORTH":
                    if (map.get("SOUTH") != null && map.get("SOUTH") > 0) {
                        int northCount = map.get("NORTH");
                        map.put("NORTH", --northCount);
                        int southCount = map.get("SOUTH");
                        map.put("SOUTH", --southCount);
//                        System.out.println("we had found twin SOUTH");
                    }
                    break;
                case "SOUTH":
                    if (map.get("NORTH") != null && map.get("NORTH") > 0) {
                        int northCount = map.get("NORTH");
                        map.put("NORTH", --northCount);
                        int southCount = map.get("SOUTH");
                        map.put("SOUTH", --southCount);
                    }
                    break;
                case "EAST":
                    if (map.get("WEST") != null && map.get("WEST") > 0) {
                        int northCount = map.get("WEST");
                        map.put("WEST", --northCount);
                        int southCount = map.get("EAST");
                        map.put("EAST", --southCount);
                    }
                    break;
                case "WEST":
                    if (map.get("EAST") != null && map.get("EAST") > 0) {
                        int northCount = map.get("WEST");
                        map.put("WEST", --northCount);
                        int southCount = map.get("EAST");
                        map.put("EAST", --southCount);
                    }
                    break;
            }
        }
        System.out.println("map = [" + map.toString() + "]");

        return new String[] {};
    }
}
