package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class NullVal {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(null);
        /**
         * 可以为空是因为：
         * 要么一开始这里就是空的
         * 要么就是冲突，取链表或者红黑树里的节点与要加入的作比较
         * 而这里计算hash，null的hash为0
         * static final int hash(Object key) {
         *      int h;
         *      return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
         *  }
         */
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put(null, 2);
        System.out.println(hashMap.get(null));
        /**
         * put方法 返回上一个val，如果事先没有，返回null
         */
        Integer old0 = hashMap.put("a", 1);
        System.out.println(old0);
        Integer old = hashMap.put("a", 2);
        System.out.println(old);


        /**
         * Hashtable
         * hashtable <过时了，不推荐使用>
         * value和 key 都不能为空
         * key不为空 是因为: line 466, int hash = key.hashCode();
         */
        Hashtable<String, Integer> hashtable = new Hashtable<>();
//        hashtable.put(null, null);
//        hashtable.put("null", null);
//        hashtable.put(null, 1);

        /**
         * value和 key 都不能为空
         * 不为空 是因为: line 1011,1012
         * if (key == null || value == null) throw new NullPointerException();
         * int hash = spread(key.hashCode());
         * 这里直接算的hashCode，不是hash
         */
        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(null,1);
        concurrentHashMap.put("1",null);

    }

}
