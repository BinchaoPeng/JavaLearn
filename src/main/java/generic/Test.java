package generic;


public class Test extends GenericClazz<String, Integer> implements GenericInterface<String> {
    public static void main(String[] args) {
        Test test = new Test();

    }
    //接口 override
    @Override
    public String genericFuncT() {
        return GenericInterface.super.genericFuncT();
    }

    @Override
    public String interfaceFunc(String s) {
        return null;
    }

    @Override
    public String func() {
        return null;
    }


    // 类 override
    // 静态方法 不可 继承
    public Test() {
        super();
    }

    public Test(String s, Integer integer) {
        super(s, integer);
    }

    @Override
    public Integer genericFunV() {
        return super.genericFunV();
    }

    @Override
    public String getK() {
        return super.getK();
    }

    @Override
    public void setK(String s) {
        super.setK(s);
    }

    @Override
    public Integer getvType() {
        return super.getvType();
    }

    @Override
    public void setvType(Integer vType) {
        super.setvType(vType);
    }


}
