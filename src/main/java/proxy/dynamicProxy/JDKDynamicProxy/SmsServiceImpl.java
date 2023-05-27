package proxy.dynamicProxy.JDKDynamicProxy;

public class SmsServiceImpl implements SmsService {
    @Override
    public void send(String msg) {
        System.out.println(this.getClass() + ", 消息服务的实现" + msg);
    }
}
