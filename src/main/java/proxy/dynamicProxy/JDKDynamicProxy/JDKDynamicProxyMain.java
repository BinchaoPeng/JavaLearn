package proxy.dynamicProxy.JDKDynamicProxy;

import java.lang.reflect.Proxy;
import java.util.ServiceLoader;

/**
 * JDKDynamicProxy
 * 一个最致命的问题是其只能代理实现了接口的类。
 */
public class JDKDynamicProxyMain {
    public static void main(String[] args) {
        SmsService service = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());  //执行完这句，应该就建立好了调用路线
        service.send(" <msg> ");
    }
}
