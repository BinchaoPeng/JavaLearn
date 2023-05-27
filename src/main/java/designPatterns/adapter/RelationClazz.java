package designPatterns.adapter;

public class RelationClazz {
    public static void Adaptee(AdapteeParent ap, Adapter_ adapter){
        System.out.println("相关类，透明方法，处理adaptee和adapter");
    }
}
