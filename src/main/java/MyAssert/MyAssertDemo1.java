package MyAssert;

/**
 * @author pbc
 */
public class MyAssertDemo1 {
    public static void func(Boolean assertFlag) {
        assert assertFlag != null : "assertFlag is null";
        System.out.println(assertFlag);
        assert assertFlag : "coming assert";
        System.out.println("after assert");
    }

    public static void main(String[] args) {
        //precondition, check param
        func(null);

        func(true);

        //when false, coming assert
        func(false);
    }
}
