package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Unsafe_ {
    /**
     * @param args
     * @CallerSensitive public static Unsafe getUnsafe() {
     * Class var0 = Reflection.getCallerClass();
     * if (!VM.isSystemDomainLoader(var0.getClassLoader())) {
     * throw new SecurityException("Unsafe");
     * } else {
     * return theUnsafe;
     * }
     * }
     */
    public static void main(String[] args) throws ClassNotFoundException {
//        getUnsafe(); // 抛异常
        Unsafe unsafe = reflectGetUnsafe();
        System.out.println(unsafe);
        System.out.println("1. 内存操作");
        /**
         * //分配新的本地空间
         * public native long allocateMemory(long bytes);
         * //重新调整内存空间的大小
         * public native long reallocateMemory(long address, long bytes);
         * //将内存设置为指定值
         * public native void setMemory(Object o, long offset, long bytes, byte value);
         * //内存拷贝
         * public native void copyMemory(Object srcBase, long srcOffset,Object destBase, long destOffset,long bytes);
         * //清除内存
         * public native void freeMemory(long address);
         */
        memoryTest(unsafe);
    }

    private static void memoryTest(Unsafe unsafe) {
        /**
         * 这种方式分配的内存属于 堆外内存 ，是无法进行垃圾回收的，
         * 需要我们把这些内存当做一种资源去手动调用freeMemory方法进行释放，否则会产生内存泄漏。
         * 通用的操作内存方式是在try中执行对内存的操作，最终在finally块中进行内存的释放。
         */
        int size = 4;
//        long address = unsafe.getAddress(465464646);
//        System.out.println("add: " + address);
        long addr = unsafe.allocateMemory(size); //申请 4 字节长度的内存空间
        long addr3 = unsafe.reallocateMemory(addr, size * 4);
        System.out.println("addr: " + addr);
        System.out.println("addr3: " + addr3);

        try {
            unsafe.setMemory(null, addr, size, (byte) 1);
            for (int i = 0; i < 2; i++) {
                unsafe.copyMemory(null, addr, null, addr3 + size * i, 4);
            }
            System.out.println(unsafe.getInt(addr)); //读取int，而java中int是4个字节，所以
            System.out.println(unsafe.getLong(addr3));
        } finally {
            // 释放 无法被 垃圾收集器 回收 的 堆外内存空间
            unsafe.freeMemory(addr);
            unsafe.freeMemory(addr3);
        }
    }


    public static Unsafe getUnsafe() throws ClassNotFoundException {
        /**
         * 会报异常
         */
        // 在getUnsafe方法中，会对调用者的classLoader进行检查，判断当前类是否由Bootstrap classLoader[引导类加载器]加载，
        // 如果不是的话那么就会抛出一个SecurityException异常。

        // 也就是说，只有启动类加载器加载的类才能够调用 Unsafe 类中的方法，来防止这些方法在不可信的代码中被调用。
        ClassLoader classLoader = Unsafe.class.getClassLoader();
        System.out.println(classLoader); // null
        classLoader.loadClass("unsafe.Unsafe_");
        Unsafe unsafe = Unsafe.getUnsafe();  // 抛异常 SecurityException
        long address = unsafe.getAddress(12655);
        System.out.println(unsafe.toString());
        System.out.println(address);
        return unsafe;
    }

    private static Unsafe CmdGetUnsafe() {
        /**
         * 通过 Java 命令行命令-Xbootclasspath/a把调用 Unsafe 相关方法的类 A 所在 jar 包路径追加到默认的 bootstrap 路径中，
         *  ==使得 A 被引导类加载器加载，==
         * 从而通过Unsafe.getUnsafe方法安全的获取 Unsafe 实例。
         */
        // java -Xbootclasspath/a: ${path}   // 其中path为调用Unsafe相关方法的类所在jar包路径
        return null;
    }

    private static Unsafe reflectGetUnsafe() {
        /**
         * 通过 反射 获取
         */
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
