package annotation;


import com.sun.istack.internal.NotNull;

public class Person {

    @Check(min = 1, max = 10, value = 100)
    public int age;

    public void out(@NotNull String name){
        System.out.println("hello "+name);
    }
    public static void main(String[] args) {
        Person ca = new Person();
        ca.age = -10;
        String s = null;
        ca.out(s);
    }
}
