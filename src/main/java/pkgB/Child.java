package pkgB;

import pkgA.Parent;

public class Child extends Parent {
    private String name;
    public String sex;
    @Override
    public void pubFunc() {
        super.pubFunc();
    }

    @Override
    protected void proFunc() {
        super.proFunc();
    }

    public void childFunc(){
        System.out.println("child function!!!");
    }
}
