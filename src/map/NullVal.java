package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class NullVal {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(null);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(null, null);
        /**
         * put方法 返回上一个val，如果事先没有，返回null
         */
        Integer old0 = hashMap.put("a", 1);
        System.out.println(old0);
        Integer old = hashMap.put("a", 2);
        System.out.println(old);


        /**
         * hashtable <过时了，不推荐使用>
         * value和 key 都不能为空
         * key不为空 是因为: line 466, int hash = key.hashCode();
         */
        Hashtable<String, Integer> hashtable = new Hashtable<>();
//        hashtable.put(null, null);
//        hashtable.put("null", null);
//        hashtable.put(null, 1);

    }

}
