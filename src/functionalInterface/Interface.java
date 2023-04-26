package functionalInterface;

/**
 * 函数式接口
 * 把只定义了单方法的接口称之为FunctionalInterface，用注解@FunctionalInterface标记。
 * 单方法指：只有一个抽象方法，可以有其他的非抽象方法或者基类重的抽象方法
 * 参考这个接口：public interface Comparator<T>
 */
@FunctionalInterface
public interface Interface {
    boolean func(String s);
}
