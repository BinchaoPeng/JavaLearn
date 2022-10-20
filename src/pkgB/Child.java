package pkgB;

import pkgA.Parent;

public class Child extends Parent {

    @Override
    public void pubFunc() {
        super.pubFunc();
    }

    @Override
    protected void proFunc() {
        super.proFunc();
    }
}
