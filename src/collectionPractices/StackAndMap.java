package collectionPractices;

import java.security.InvalidKeyException;
import java.util.*;

public class StackAndMap {
    public static void main(String[] args) {
        Map<List<Integer>, Integer> res = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        res.put(list, 6);
        list = new ArrayList<>();
        list.add(2);
        list.add(3);
        res.put(list, 5);
        Deque<Map.Entry<List<Integer>, Integer>> stack = new LinkedList<>();
        for (Map.Entry<List<Integer>, Integer> e : res.entrySet()){
            stack.push(e);
        }
        Set<List<Integer>> lists = res.keySet();
        


    }
}
