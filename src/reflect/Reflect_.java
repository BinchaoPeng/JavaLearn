package reflect;

import pkgA.Parent;
import pkgB.Child;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 会连同父类的能访问到的，一起获取到
 * 自己私有的字段也拿不到
 * 父类引用，也是看new的那个类
 * Class类是一个泛型类
 */
public class Reflect_ {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        System.out.println("通过类的路径获取类");
        Class clazz = Class.forName("pkgB.Child");
        reflect(clazz);

        System.out.println("通过某个具体对象实例获取类");
        Child child = new Child();
        Class clazz1 = child.getClass();
        reflect(clazz1);

        System.out.println("通过 类名.class 获取类");
        Class clazz2 = Child.class;
        reflect(clazz2);

        System.out.println("通过 类名.class 获取类，采用父类引用");
        Parent parent = new Child();
        Class clazz3 = parent.getClass();
        reflect(clazz3);

        System.out.println("通过类加载器xxxClassLoader.loadClass()传入类路径获取");
        Class<?> clazz4 = ClassLoader.getSystemClassLoader().loadClass("pkgB.Child");

        /**
         * 使用步骤
         */
        // 创建实例
        Child c = (Child) clazz.newInstance();
        // 调用指定方法  method.invoke()
        Field value = clazz.getDeclaredField("name"); // 这里又可以拿到自己私有的字段
//        Field value0 = clazz.getDeclaredField("pub"); // 拿不到原本子类可以访问父类的public字段
        Method value1 = clazz.getDeclaredMethod("childFunc");
        Constructor value2 = clazz.getDeclaredConstructor();


    }

    public static void reflect(Class clazz) {
        Field[] fields = clazz.getFields();
        Method[] methods = clazz.getMethods();
        Constructor[] constructors = clazz.getConstructors();

        System.out.println("fileds: " + fields.length);
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName() + ", " + fields[i].getClass());
        }
        System.out.println();
        System.out.println("methods: " + methods.length);
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName() + ", " + methods[i].getClass());
        }
        System.out.println();
        System.out.println("constructors: " + constructors.length);
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName() + ", " + constructors[i].getClass());
        }
        System.out.println();
    }
}
