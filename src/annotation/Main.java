package annotation;

import controlVisit.P;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Person p = new Person();
        p.age = 1;
        annotationCheck(p);
        System.out.println(p.age);
        Arrays.sort(new String[]{"a", "b"});

    }

    public static void annotationCheck(Person person) throws NoSuchFieldException {
        // 处理字段 age
        Field f = Person.class.getField("age");
        if (f.isAnnotationPresent(Check.class)) {
            //表示 使用了 @Chjeck 这个注解
            // 因此，执行检查逻辑
            Check check = f.getAnnotation(Check.class);
            if (person.age < check.min() || person.age > check.max()) {
                throw new IllegalArgumentException(String.format(f.getName() + " must be in [%d, %d]", check.min(), check.max()));
            }
        }

    }
}
