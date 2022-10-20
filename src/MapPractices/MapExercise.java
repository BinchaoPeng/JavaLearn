package MapPractices;

import java.util.*;

public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("001",new Employee("001","jack",18,19000));
        map.put("002",new Employee("001","pbc",24,780.65));
        map.put("003",new Employee("001","rose",19,720));

        Collection values = map.values();
        for (Object v :
                values) {
            Employee e = (Employee) v;
            if(e.getSalary()>=18000){
                System.out.println(e);
            }
        }

        Set entrySet = map.entrySet();
        Iterator iter = entrySet.iterator();
        while (iter.hasNext()){
            Object o = iter.next();
            Map.Entry entry = (Map.Entry) o;
            Employee e = (Employee) entry.getValue();
            if (e.getSalary()>18000){
                System.out.println(e);
            }
        }

    }
}

class Employee{
    private String id;
    private String name;
    private int age;
    private double salary;

    public Employee(String id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}