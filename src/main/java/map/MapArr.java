package map;

import java.util.HashMap;
import java.util.Map;

public class MapArr {
    public static void main(String[] args) {
        Map<String, int[]> re = new HashMap<>();
        re.put("{", new int[]{1, 3, 4});
        re.put("{{", new int[]{1, 3, 4, 4, 5});

        Map<Character, Integer> re1 = new HashMap<>();

    }
}
