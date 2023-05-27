package Test;

public class Change {
    public static void main(String[] args) {
        Animals cat = new Cat("cat");
        Animals dog = new Dog("dog");
        int a = 10;
        int b = 5;
        Transform.transformer(cat, dog);
        System.out.println("cat:" + cat.getType());
        System.out.println("dog:" + dog.getType());
        Transform.transformer(a, b);
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        String s = "1";
        char c = '1';
        char d = '1';
        System.out.println(c == d);
        System.out.println(s.equals(c+""));
        System.out.println(s.equals(c));
        System.out.println();
    }
}

class Transform {
    public static void transformer(Integer a, Integer b) {
        Integer temple = a;
        a = b;
        b = temple;
    }

    public static void transformer(Animals a, Animals b) {
        Animals tem = a;
        a = b;
        b = tem;
    }
}


class Animals {
    private String type = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Dog extends Animals {
    private String type = "Dog";

    public Dog(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


class Cat extends Animals {
    private String type = "Cat";

    public Cat(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}