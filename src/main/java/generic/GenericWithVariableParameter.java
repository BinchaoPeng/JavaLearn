package generic;

import java.util.Arrays;
import java.util.List;

public class GenericWithVariableParameter {
    public static <T> int asList(T... a) {
        System.out.print("泛型 + ");
        return a.length;
    }

//    public static int asList(int[] a) {
//        System.out.print("int[] + ");


//        return a.length;
//    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int i = asList(a); // a作为整体传入
        System.out.println(i);
        int i1 = asList(1, 2, 3);
        System.out.println(i1);
    }
}
