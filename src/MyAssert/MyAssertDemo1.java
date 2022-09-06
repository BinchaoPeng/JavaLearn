package MyAssert;

/**
 * @author pbc
 */
public class MyAssertDemo1 {
    public static void func(boolean assertFlag){
        System.out.println(assertFlag);
        assert assertFlag : "coming assert";
        System.out.println("after assert");
    }

    public static void main(String[] args) {
        func(true);

        //when false, coming assert
        func(false);
    }
}
