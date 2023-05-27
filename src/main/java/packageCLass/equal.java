package packageCLass;

@SuppressWarnings("all")
public class equal {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i11 = 127;
        int i111 = 127;

        Integer i2 = 128;
        Integer i22 = 128;
        int i222 = 128;

        Integer i3 = -128;
        Integer i33 = -128;
        int i333 = -128;

        Integer i4 = -129;
        Integer i44 = -129;
        int i444 = -129;

        // -128 - 127之间，基本类型包装类，除了两种浮点类型，都实现了常量池技术，直接使用对象池。
        // 相当于直接比数字
        System.out.println(i1 == i11);
        System.out.println(i1 == i111);
        System.out.println(i3 == i33);
        System.out.println(i3 == i333);

        System.out.println(i2 == i22);  // false
        System.out.println(i2 == i222); // 自动拆箱，ture

        System.out.println(i4 == i44);
        System.out.println(i4 == i444);
    }


}
