package designPatterns.decorator;

public class Origin extends OriginParent implements OriginInterface {
    @Override
    public void funcFromParent() {
        System.out.println("子类：适配者父类提供的方法");
    }

    @Override
    public void funcFromInterface() {
        System.out.println("子类：适配者接口提供的方法");
    }

}
