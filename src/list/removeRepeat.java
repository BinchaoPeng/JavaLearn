package list;

import java.util.*;

public class removeRepeat {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        res.add(list);
        System.out.println(list.hashCode());
        list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        res.add(list);
        System.out.println(list.hashCode());
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        res.add(list);
        System.out.println(list.hashCode());
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(new HashSet<List<Integer>>(res));
    }
}
