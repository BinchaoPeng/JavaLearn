package entity;

/**
 * hello world
 * @author pbc
 */
public class Person {
    private String name;
    private int age;
    private int sex;

    public Person(){

    }

    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

class Stu extends Person {
    private int stuId;
}

class Test {
    public static void main(String[] args) {
        Stu s = new Stu();
        Class sc = s.getClass();
        Class pc = Person.class;
        System.out.println(sc);
        System.out.println(pc);
        System.out.println(sc == pc);
        System.out.println(sc == Stu.class);
        System.out.println(s instanceof Person);
        System.out.println(s instanceof Stu);
    }
}