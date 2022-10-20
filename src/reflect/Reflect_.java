package reflect;

import pkgB.Child;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect_ {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("pkgB.Child");

        Child child = new Child();

        Class clazz1 = child.getClass();

        Class clazz2 = Child.class;


        Field[] fields = clazz1.getFields();
        Method[] methods = clazz1.getMethods();
        Constructor[] constructors = clazz1.getConstructors();

    }
}
