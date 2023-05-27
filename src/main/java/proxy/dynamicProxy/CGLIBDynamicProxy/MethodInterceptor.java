package proxy.dynamicProxy.CGLIBDynamicProxy;

import java.lang.reflect.Method;

/**
 * 为了通过编译
 * 具体实现要添加依赖
 */
public interface MethodInterceptor {

    /**
     * 拦截 增强 被代理类 的 方法
     * @param o
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable;
}
