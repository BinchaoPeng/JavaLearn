package controlVisit;

public class C extends P{
    public static void main(String[] args) {
        C c = new C();
        c.getMsg();

        P p = new C();
        p.getMsg();
    }

    @Override
    protected String getMsg() {
        return super.getMsg();
    }

    private void printMsg(){
        System.out.println(getMsg());  // 直接访问
        System.out.println(super.getMsg()); // 访问父类方法
    }
}
