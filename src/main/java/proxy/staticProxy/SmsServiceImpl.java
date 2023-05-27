package proxy.staticProxy;

public class SmsServiceImpl implements SmsService {
    @Override
    public void sendMsg(String msg) {
        System.out.println(this.getClass() + ", 短信发送服务的实现");
    }
}
