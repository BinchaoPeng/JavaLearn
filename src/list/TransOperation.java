package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://javaguide.cn/java/collection/java-collection-precautions-for-use.html
 */
public class TransOperation {
    public static void main(String[] args) {
        List2Map();
        list2array();
        array2listWithBaseType();
    }

    static void array2listWithBaseType() {
        int[] a = {1, 2, 3};
        System.out.println("方法一，不能使用泛型，要直接写元素进去，不能使用数组对象替代");
        /**
         * Arrays.asList(a)
         * a是可变参数，且是泛型
         * 当`int[] a = {1, 2, 3};`传入时，a是一个参数
         */
        List list = new ArrayList<>(Arrays.asList(a)); // 会整体看成一个元素，相当于 list只有一个元素，这个元素是数组
        //这里会报错，相当于 list只有一个元素，这个元素是数组
//        System.out.println(list.get(1).getClass() + " " + list.get(1));
        System.out.println(Arrays.toString(list.toArray()));
        list = new ArrayList<>(Arrays.asList(1, 2, 3)); // 会看成三个元素
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.get(0).getClass() + " " + list.get(0));
        System.out.println(list.get(1).getClass() + " " + list.get(1));//正常
        System.out.println("方法二，Java8的流，推荐使用");
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int[] myArray2 = {1, 2, 3};
        myList = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
    }

    static void errorOpera() {
        /**
         * Arrays.asList() 方法返回的并不是 java.util.ArrayList ，
         * 而是 java.util.Arrays 的一个内部类,
         * 这个内部类并没有实现集合的修改方法或者说并没有重写这些方法
         *
         */
        List myList = Arrays.asList(1, 2, 3);
        myList.add(4);//运行时报错：UnsupportedOperationException
        myList.remove(1);//运行时报错：UnsupportedOperationException
        myList.clear();//运行时报错：UnsupportedOperationException

    }

    static void list2array() {
        /**
         * 一定要是 对象数组，
         * 基本类型的不能这样
         */
        String[] s = new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        // 直接返回非空数组
        List<String> list = Arrays.asList(s);//是浅拷贝，参数是数组
        list.set(0, "cat");
        System.out.println(Arrays.toString(s));
        //内部调用了这个：elementData = Arrays.copyOf(a, size, Object[].class);
        List<String> list1 = new ArrayList<>(list); //是深拷贝，参数是list
        list1.set(1, "cat");
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(list1.toArray()));

//        Collections.reverse(list);
        // System.arraycopy(elementData, 0, a, 0, size);
        //没有指定类型的话会报错
        String[] re = list.toArray(new String[0]); //深拷贝
        re[3] = "cat";
        System.out.println(Arrays.toString(s));
    }

    static void List2Map() {
        class Person {
            private String name;
            private String phoneNumber;

            public Person(String name, String phoneNumber) {
                this.name = name;
                this.phoneNumber = phoneNumber;
            }

            // getters and setters

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }
        }

        List<Person> bookList = new ArrayList<>();
        bookList.add(new Person("jack", "18163138123"));
        /**
         * list转map时，
         * value不能为空
         * key可以
         */
//        bookList.add(new Person("martin", null));
        bookList.add(new Person(null, "110"));
        // 空指针异常
        bookList.stream().collect(Collectors.toMap(Person::getName, Person::getPhoneNumber));

    }
}
