package map;

import java.util.*;
import java.util.function.BiConsumer;

public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("hello", "world");
        map.put(1, 2);
        map.put("age", 3);
        map.put("price", 6.6);

        for (Object en : map.entrySet()) {
            Map.Entry entry = (Map.Entry) en;
        }

        Set entrySet = map.entrySet();
        Collection values = map.values();
        Set keySet = map.keySet();

        //使用keySet遍历
        for (Object key :
                keySet) {
            Object value = map.get(key);
            System.out.println(key + ": " + value);
        }
        System.out.println("=========================");
        //使用迭代器遍历keySet
        Iterator iter = keySet.iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            System.out.println(key + ": " + map.get(key));
        }
        System.out.println("=========================");

        //使用values遍历
        for (Object v : values) {
            System.out.println(v);
        }
        iter = values.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //使用entrySet做遍历
        for (Object entry : entrySet) { // EntrySet<Map.Entry<K,V>>
            //每个entry都是 ‘java.util.HashMap$Node’，也就是Map.Entry
            // HashMap$Node -实现了-> Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + ": " + m.getValue());
        }

        System.out.println("使用函数式接口，lambda表达式遍历map");
        map.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println(o + "," + o2);
            }
        });
        map.forEach((key, val) -> System.out.println(key + ", " + val));

    }
}
