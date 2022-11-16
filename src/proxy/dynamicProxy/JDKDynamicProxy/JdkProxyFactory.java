package proxy.dynamicProxy.JDKDynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂类
 */
public class JdkProxyFactory {
    /***
     * target是目标类对象，也就是 服务的具体实现的 对象实例
     * @param target
     * @return
     */
    public static Object getProxy(Object target) {
        // 传入 serviceImpl
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new InvocationHandlerImpl(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }

}
