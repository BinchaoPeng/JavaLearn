package reflect.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        /**
         * 用于动态处理方法的逻辑
         * 负责实现接口的方法调用；
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(proxy.getClass().getName());
                System.out.println(method.getName());
                if ("hello".equals(method.getName())) {
                    // 实现 hello方法 的逻辑
                    System.out.println("Hello " + args[0] + "!");
                }
                return null;
            }
        };

        /**
         * 创建interface实例
         * 这里动态代理
         * 用于创建一个 实现了Base接口 的实例对象
         */
        Base base = (Base) Proxy.newProxyInstance(
                Base.class.getClassLoader(),
                new Class[]{Base.class},
                invocationHandler
        );
        base.hello("pbc");
    }
}
