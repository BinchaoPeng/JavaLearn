package entity;

/**
 * @author pbc
 */
public class Student extends Person implements Cloneable, Comparable<Student> {

    private String stuId;

    public Student() {
    }

    public Student(String stuId) {
        this.stuId = stuId;
    }

    public Student(String name, int age, int sex, String stuId) {
        super(name, age, sex);
        this.stuId = stuId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {

        return "Student{" +
                "stuId=" + stuId +
                '}' + " extends " + super.toString();
    }

    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            System.out.println("cloned!!!");
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(Student student) {

        System.out.println("compareTo");
        return this.getStuId().length() - student.getStuId().length();
    }

    public class InnerStu {
        private String innerFlag;

        public String getInnerFlag() {
            return innerFlag;
        }

        public void setInnerFlag(String innerFlag) {
            this.innerFlag = innerFlag;
        }

        public void innerF() {
            this.innerFlag = "inner";

        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s = new Student("pbc", 18, 1, "20032303092");
        Student s2 = new Student("pbc", 18, 1, "200323030");

        System.out.println(s.compareTo(s2));

        Student s1 = s.clone();

        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
    }


}
