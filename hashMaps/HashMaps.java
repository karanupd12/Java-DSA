package hashMaps;
import java.util.HashMap;
import java.util.HashSet;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Karan", 89);
        map.put("John", 94);
        map.put("Max", 90);
        System.out.println(map.get("Karan"));    //89
        System.out.println(map.getOrDefault("John", 88));     // 94, because John exist in database
        System.out.println(map.getOrDefault("Dave", 80));     // 80, default value because Dave is not in data

        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(45);
        set.add(56);
        set.add(12);
        set.add(33);
        System.out.println(set);  // [33, 56, 12, 45]   -->  56 is not added again as HashSet cannot contain duplicate values
    }
}
