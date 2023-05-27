package map;

import java.util.HashMap;
import java.util.Map;

public class MapNew {
    static final Map map = new HashMap();

    static {
        map.put("1", 3);
    }

    public static void main(String[] args) {
        Map map = new HashMap() {
            {
                put('a', 1);
                put('b', 2);
            }
        };
        System.out.println(map.keySet());



    }
}
