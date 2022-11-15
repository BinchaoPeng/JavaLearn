package copy;

/**
 * 拷贝总结
 * 实现cloneable接口，这个接口是标志接口，里面啥也没有
 * 重写clone方法，返回值修改成对应类的类型，使用强制类型转换，因为默认是Object
 * 直接`super.clone()`就是复制，这本质上是深拷贝，但是只是拷贝最外层的对象实例
 * 这个最外层对象实例，有可能还包含其他对象
 * 其他对象就不会被拷贝，基本类型数据和String类型的会自动深拷贝
 * 一般自定义的对象不会，需要嵌套的重写clone方法
 */
class Address implements Cloneable {
    public String add;

    public Address(String add) {
        this.add = add;
    }

    @Override
    public Address clone() {
        Address address;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
        return address;
    }
}

public class DeepCopy implements Cloneable {
    /*
    深拷贝
    连同实例的内容一同复制
     */

    private int age;
    private String name;

    private Address address;

    public DeepCopy(String name, int age, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected DeepCopy clone() {
        DeepCopy c;
        try {
            c = (DeepCopy) super.clone();
            c.setAddress(c.getAddress().clone());
        } catch (CloneNotSupportedException e) {
            System.out.println("exception: " + e.getMessage());
            throw new AssertionError();
        }
        return c;
    }

    @Override
    public String toString() {
        return "DeepCopy{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        DeepCopy clone = new DeepCopy("pbc", 25, new Address("beijing"));
        DeepCopy clone1 = clone.clone();
        // 引用的地址 不一样
        System.out.println(clone);
        System.out.println(clone1);
        // 查看对象内容
        System.out.println(clone);
        System.out.println(clone1);
        clone1.setAddress(new Address("nanchang"));
        clone1.setName("PBC");
        clone1.setAge(18);
        System.out.println(clone);
        System.out.println(clone1);
    }
}
