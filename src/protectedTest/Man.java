package protectedTest;

public class Man extends Person{
    private String sex = "man";

    @Override
    protected void profunc() {
        System.out.println("Man 可以实现 protected func！");
    }


}
