package proxy.staticProxy;

public class SmsProxy implements SmsService {
    public final SmsService smsService;

    public SmsProxy(SmsService service) {
        this.smsService = service;
    }

    @Override
    public void sendMsg(String msg) {
        System.out.println(this.getClass() + ", 短信代理类，调用短信服务实现方法之前。。。");
        smsService.sendMsg(msg);
        System.out.println(this.getClass() + ", 短信代理类，调用短信服务实现方法之前。。。");
    }
}
