package generic;

public class Main {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        /**
         * extends通配符
         * 只读不写
         */
//        Number f = new Integer(first.intValue() + 100);
//        Number l = new Integer(last.intValue() + 100);
//        p.setFirst(f);
//        p.setLast(l);
        return p.getFirst().intValue() + p.getFirst().intValue();
    }

}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }
}
