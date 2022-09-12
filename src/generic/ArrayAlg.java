package generic;

import java.util.ArrayList;

//定义
class ArrayAlg{
    public static <T> T getMiddle(T... a){
        return a[a.length / 2];
    }

    public static void main(String[] args) {
        //调用
        String middle = ArrayAlg.<String>getMiddle("jack","a","public");
        System.out.println(middle);
        ArrayList<String> a = new ArrayList<>();

    }
}

