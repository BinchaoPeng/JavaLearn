package reflect.src.com.itranswarp.learnjava;

import java.lang.reflect.Field;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String name = "Xiao Ming";
        int age = 20;
        Person p = new Person();
        // TODO: 利用反射给name和age字段赋值:
        Class c = p.getClass();
        Field f = c.getDeclaredField("name"); // getDeclaredField可以访问到所有权限的字段（不包括父类）；getField获取某个public的field（包括父类）
        f.setAccessible(true);
        f.set(p, name);
        Field f1 = c.getDeclaredField("age");
        f1.setAccessible(true);
        f1.set(p, age);
        System.out.println(p.getName()); // "Xiao Ming"
        System.out.println(p.getAge()); // 20
    }
}
