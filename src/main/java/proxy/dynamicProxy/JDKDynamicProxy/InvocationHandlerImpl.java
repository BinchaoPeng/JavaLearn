package proxy.dynamicProxy.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {
    private final Object target;// 目标对象，服务的具体实现类的对象实例

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("HandlerImpl: 服务方法调用之前");
        Object invoke = method.invoke(target, args);
        System.out.println("HandlerImpl: 服务方法调用之后");
        return invoke;
    }
}
