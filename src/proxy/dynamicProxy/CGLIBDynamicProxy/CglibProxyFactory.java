package proxy.dynamicProxy.CGLIBDynamicProxy;

/**
 * 通过Enhancer类（需要添加cglib依赖）的create方法 创建 代理类
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        /**
         * clazz 就是 服务类，是被代理的那个
         */
        // 创建 动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置 被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
