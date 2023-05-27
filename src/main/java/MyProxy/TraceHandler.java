package MyProxy;

import entity.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 调用处理器，用于跟踪目标对象的方法调用
 * @target 代理类对象
 */
public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}

class Main{
    public static void main(String[] args) {
        // 主体对象
        Object s = new Student("jack",18,1,"20032303092");
        //调用处理器，包装了主体对象
        TraceHandler trace = new TraceHandler(s);
        //代理，构造指定接口的代理，运行时动态创建新类
        Object proxy = Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Comparable.class},
                trace
        );
    }
}