package protectedTest.others;

import protectedTest.Man;
import protectedTest.Person;
import protectedTest.school.Teacher;

public class Main {
    public Person personPub;
    public String m;



    public static void main(String[] args) {
        // 这里是 default，因此都不能跨包访问
        Person person = new Teacher();

        Man man = new Man();

        Teacher teacher = new Teacher();


    }
}
