package map;

public class Hash {
    public static void main(String[] args) {
        String a = "11";
        String b = "11";
        String c = new String("11");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a == b);
        System.out.println(a == c);
    }
}
