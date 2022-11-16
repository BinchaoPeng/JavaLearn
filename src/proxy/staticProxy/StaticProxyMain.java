package proxy.staticProxy;

/**
 * 静态代理
 * 相当于通过proxy这个中间人去获取具体服务
 * 就是代理类也实现了该服务接口，然后对应方法调用服务实现类的同名方法
 * 这样也可以在调用前后，增加额外的操作。起到了，方法增强的效果
 *
 * 缺点：增加接口时不灵活，需要修改很多地方；有多少个目标类就要写多少个代理类，很麻烦
 */
public class StaticProxyMain {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy proxy = new SmsProxy(smsService);
        proxy.sendMsg("我发送短信了。。。");
    }
}
