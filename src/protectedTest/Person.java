package protectedTest;

public class Person {
    private String name;

    protected String info;


    protected void profunc() {
        System.out.println("Person protected function!");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
