package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class List_ {
    public static void main(String[] args) {
        List<Objects> list = null;

        List<String> list1 = null;

        ArrayList<String> a = new ArrayList<String>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        Class c1 = a.getClass();
        Class c2 = b.getClass();
        System.out.println(c1 == c2);
    }

    public static void func(List<Objects> list){
        System.out.println("!!!");
    }
}
