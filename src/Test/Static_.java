package Test;

public class Static_ {
    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    int i = 1, j = 1;

    public static void main(String[] args) {
        System.out.println("m");
        Static_ static_ = new Static_();
        System.out.println("main");
    }


    static {
        System.out.println("3");
    }
}
