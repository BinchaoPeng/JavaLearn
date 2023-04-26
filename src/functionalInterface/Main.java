package functionalInterface;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 使用Lambda表达式，我们就可以不必编写FunctionalInterface接口的实现类，从而简化代码
 *
 * FunctionalInterface允许传入：
 *  接口的实现类（传统写法，代码较繁琐）；
 *  Lambda表达式（只需列出参数名，由编译器推断类型）；
 *  符合方法签名的静态方法；
 *  符合方法签名的实例方法（实例类型被看做第一个参数类型）；
 *  符合方法签名的构造方法（实例类型被看做返回类型）。
 *  FunctionalInterface不强制继承关系，不需要方法名称相同，只要求方法参数（类型和数量）与方法返回类型相同，即认为方法签名相同。
 */
public class Main {
    public static void main(String[] args) {
        Arrays.sort(new Integer[]{2, 34, 1, 234}, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        /**
         * 一般写法
         */
        fi("meili", new Interface() {
            @Override
            public boolean func(String s) {
                System.out.println(s);
                if (s != null) {
                    return true;
                }
                return false;
            }
        });

        /**
         * lambda表达式
         * 去除了类的写法，也不用描述参数的类型、返回类型、以及方法名
         * 只要写入逻辑就可以
         *
         */
        fi("meili",(s)->{
            System.out.println(s);
            if (s != null) {
                return true;
            }
            return false;
        });

        /**
         * 直接传入方法引用
         * 所谓方法引用，是指如果某个方法签名和接口恰好一致，就可以直接传入方法引用。
         * 在这里，方法签名只看参数类型和返回类型，不看方法名称，也不看类的继承关系。
         * 对于实例方法，实例方法有一个隐含的this参数，在实际调用的时候，第一个隐含参数总是传入this，然后是方法的其他参数
         * 对于静态方法，在这里，可以理解为显式地写出了this参数，本质上与实例方法可以对等
         * 对于构造方法，构造方法的引用写法是类名::new。而构造方法虽然没有return语句，但它会隐式地返回this实例
         *
         */
        // 。。。

    }

    static void fi(String s, Interface in) {
        boolean func = in.func(s);
        System.out.println(func);
    }
}
