package designPatterns.adapter;

/**
 * 提供透明的方法
 * 供 适配器 调用
 */
public class AdapteeParent {
    public void funcFromParent() {
        System.out.println("父类：适配者父类提供的方法");
    }
}
