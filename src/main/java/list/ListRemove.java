package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRemove {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(Integer.valueOf(1)); // 用对象才行
        System.out.println(Arrays.toString(list.toArray()));
    }
}
