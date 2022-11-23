package array;

import java.util.Arrays;

public class ArrayscopyOfTest {
    public static void main(String[] args) {
        int[] old = {1,2,3};
        int[] now = Arrays.copyOf(old, 2);
        System.out.println(Arrays.toString(now));
        old[1] = 1;
        System.out.println(Arrays.toString(now));
    }
}
