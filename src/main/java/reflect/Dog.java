package reflect;

public class Dog implements Inter{
    @Override
    public String med(String msg) {
        System.out.println("implement in Dog");
        return msg;
    }
}
