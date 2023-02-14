package designPatterns.decorator;

/**
 * 增强类，提供增强功能
 */
public class Expand extends OriginParent implements OriginInterface {
    private OriginParent op;

    public Expand(OriginParent op) {
        this.op = op;
    }

    @Override
    public void funcFromParent() {
        System.out.println("增强类实现父类方法");
        System.out.println(this.op.getClass());
    }

    @Override
    public void funcFromInterface() {
        System.out.println("增强类实现接口方法");
    }

    public static void main(String[] args) {
        Origin origin = new Origin();
        Expand expand = new Expand(origin);
        expand.funcFromParent();
    }
}
