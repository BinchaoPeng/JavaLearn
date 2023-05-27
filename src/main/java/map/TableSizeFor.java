package map;


public class TableSizeFor {
    public static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 按位与
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(n + " " + Integer.toBinaryString(n));
        System.out.println((n >>> 1) + " " + Integer.toBinaryString(n >>> 1));
        System.out.println((n | (n >>> 1)) + " " + Integer.toBinaryString(n | (n >>> 1)));
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        int re = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(re);
        return re;
    }

    public static void main(String[] args) {
        int re = tableSizeFor(5);
        System.out.println(re);

    }

}
