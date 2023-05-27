package annotation;

// todo 记得修正
/**
 * 这里没有成功
 */

public class Person {

    @Check(min = 1, max = 10, value = 100)
    public int age;

//    public void out(@NotNull String name){
    public void out( String name){
        System.out.println("hello "+name);
    }
    public static void main(String[] args) {
        Person ca = new Person();
        ca.age = -10;
        String s = null;
        ca.out(s);
    }
}
