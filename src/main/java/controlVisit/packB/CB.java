package controlVisit.packB;

import controlVisit.C;
import controlVisit.P;

import java.util.HashMap;
import java.util.Map;

public class CB extends P {
    public static void main(String[] args) {

        CB CB = new CB();
        CB.getMsg(); // 可以访问，这是因为protected允许子类访问继承过来的protected方法
        C c = new C();
//        c.getMsg(); //不可以，跨包了

        P p = new CB();
//        p.getMsg();  // 虽然是子类，但是父类引用不是在同一个包下，所以就不能访问

    }

    private void printMsg(){
        System.out.println(getMsg());  // 直接访问
        System.out.println(super.getMsg()); // 访问父类方法
    }
}
