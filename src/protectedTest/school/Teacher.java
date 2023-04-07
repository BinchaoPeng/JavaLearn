package protectedTest.school;

import protectedTest.Man;
import protectedTest.Person;

public class Teacher extends Person {
    private String grade;

//    @Override
//    protected void profunc() {
//        System.out.println("Teacher 可以实现 protected function！");
//    }


    public static void main(String[] args) {
        Person person = new Teacher();
//        person.profunc(); 访问不到，非public方法

        Teacher teacher = new Teacher();
        teacher.profunc(); // todo 可以访问，因为在子类里《对比该包下的Main》

        Man man = new Man();
//        man.profunc();  // 访问不到，非public方法

    }
}
