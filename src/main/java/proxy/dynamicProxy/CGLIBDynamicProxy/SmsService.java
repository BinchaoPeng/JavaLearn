package proxy.dynamicProxy.CGLIBDynamicProxy;

/**
 * 定义一个类
 * 提供具体服务
 * 由 方法拦截器 调用
 */
public class SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

}
