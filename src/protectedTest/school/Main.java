package protectedTest.school;

import protectedTest.Person;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
//        teacher.profunc();   //todo 不能访问，没有重写这个方法，找父类，父类跨包了，不能访问《对比该包下的Teacher》

        Person person = new Person();
//        person.profunc(); // 不能访问，跨包了
    }
}
