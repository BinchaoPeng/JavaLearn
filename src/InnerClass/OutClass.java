package InnerClass;

import java.util.HashMap;
import java.util.Map;

public class OutClass {
    /**
     * main
     */
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.anonymous();

        InnerClass innerClass = outClass.new InnerClass(); // outClass.new
        new StaticClass();



    }

    /**
     * InnerClass
     */
    class InnerClass extends Father {
        public InnerClass() {
            System.out.println("我是内部类，必须依靠外部类的实例存在！");
            map.put("Inner", "val"); //访问到了外部
            anonymous(); // 访问到了外部
        }
    }

    /**
     * Anonymous Class
     */
    Map map = new HashMap<String, String>() {
        {
            put("key", "value");
        }
    };

    private void anonymous() {
        Runnable runnable = new Runnable() {
            // 实现Runnable接口的匿名类
            // 并转型到接口
            // 接口本身不能实例化
            @Override
            public void run() {
                System.out.println("我是匿名类，直接实现了Runnable接口！");
                map.put("Anonymous", "val"); //访问到了外部
            }
        };
        new Thread(runnable).start();
    }

    static String name = "aa0";

    /**
     * 静态内部类（Static Nested Class）
     */
    static class StaticClass extends Father {
        public StaticClass() {
            System.out.println("我是 静态内部类，不再依附外部类，不用通过外部类实例后再new自己，但也可以访问外部类的成员");
            name = "static"; //只能访问外部静态，方法也是

        }
    }
}
