package proxy.dynamicProxy.CGLIBDynamicProxy;

public class CglibProxyMain {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) CglibProxyFactory.getProxy(SmsService.class);//执行完这句，应该就建立好了调用路线
        smsService.send("java");

    }
}
