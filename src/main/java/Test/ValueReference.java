package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueReference {
    public static void main(String[] args) {
        List l = new ArrayList<Integer>();
        List l1 = new ArrayList();
        l1.add(1);
        l1.add(2);
        l1.add(2);
        l.addAll(l1);

        List l2 = changeList(l);

        System.out.println(Arrays.toString(l.toArray()));
        System.out.println(Arrays.toString(l1.toArray()));
        System.out.println(Arrays.toString(l2.toArray()));
    }


    public static List changeList(List l){
        l.clear();
        return l;
    }
}
