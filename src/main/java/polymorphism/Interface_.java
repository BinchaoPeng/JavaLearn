package polymorphism;

public interface Interface_ {
    int val = 1;

    default int priFun() {
        System.out.println("I am interface, priFun!");
        return -1;
    }

    int func(int val);
}
