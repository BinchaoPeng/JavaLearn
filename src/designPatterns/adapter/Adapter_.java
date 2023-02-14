package designPatterns.adapter;

/**
 * 对象适配器，采用 组合关系 实现
 * 类适配器，采用 继承 实现
 *
 */
public class Adapter_ {
    public Adapter_(AdapteeParent ap) {
        /**
         * 这里调用相关类的方法
         */
        RelationClazz.Adaptee(ap, this);
    }

    public static void main(String[] args) {
        Adapter_ adapter = new Adapter_(new Adaptee());
    }
}
