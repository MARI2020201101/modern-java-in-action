package ch08;

import java.util.HashMap;
import java.util.Map;

public class MergeEx {
    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<>();
        map.put("james", 1L);
        String name = "mmm";
        map.merge(name, 1L, (l1, l2) -> l2);
        System.out.println(map);
    }
}
