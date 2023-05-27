package Test;

public class Static_ {
    int k = 1, j = 1;
    static int i = 10;

    static {
        i += 5;
        System.out.println("1");
    }

    {
        System.out.println("2");
    }


    public static void main(String[] args) {
        System.out.println("m");
        Static_ static_ = new Static_();
        System.out.println("main");
        System.out.println(static_.i);
        System.out.println(Static_.i);
    }


    static {
        i /= 3;
        System.out.println("3");
    }
}
