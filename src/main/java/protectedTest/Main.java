package protectedTest;

import protectedTest.school.Teacher;

public class Main {
    public static void main(String[] args) {
        Person person = new Teacher();
        person.profunc(); // 和person在同一个包下面，动态绑定了。首先是default，可以访问person的profunc方法，其次动态绑定

        Man man = new Man();
        man.profunc(); //没跨包

        Teacher teacher = new Teacher();
        //跨包了，按理来说访问不到他的非public方法（此时没有overide，但父类在这，访问的是父类的方法，在同一个包所以就可以访问了）；
        // 当overide后，就不能访问了，因为是非public方法
        teacher.profunc();
    }
}
