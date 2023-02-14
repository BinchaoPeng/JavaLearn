package designPatterns.adapter;


public class Adaptee extends AdapteeParent implements AdapteeInterface {
    @Override
    public void funcFromParent() {
        System.out.println("子类：适配者父类提供的方法");
    }

    @Override
    public void funcFromInterface() {
        System.out.println("子类：适配者接口提供的方法");
    }

    public static void main(String[] args) {
        AdapteeParent ap = new Adaptee();
        ap.funcFromParent();
    }
}
