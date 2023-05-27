package list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ListSort implements Comparator<Integer> {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 3, 2, 5, 4};
        sortPartition(nums, 0, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortPartition(Integer[] nums, int from, int to) {
//        int[] ints = Arrays.copyOfRange(nums, from, to);
//        Arrays.sort(ints,0,3);
//        System.out.println(Arrays.toString(ints));
//        if (to - from >= 0) System.arraycopy(ints, from, nums, from, to - from);
        Arrays.sort(nums, 0, 3, new ListSort());
    }


    @Override
    public int compare(Integer o1, Integer o2) {
        System.out.println("inner");
        return o2 - o1;
    }
}

class Com implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        System.out.println("outer");
        return o2 - o1;
    }
}