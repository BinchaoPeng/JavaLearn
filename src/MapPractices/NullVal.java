package MapPractices;

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
         * hashtable <过时了，不推荐使用>
         * value和key 都不能为空
         * key不为空 是因为: line 466, int hash = key.hashCode();
         */
        Hashtable<String, Integer> hashtable = new Hashtable<>();
//        hashtable.put(null, null);
//        hashtable.put("null", null);
        hashtable.put(null, 1);
    }

}
