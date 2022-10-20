package Test;

public class Test {
    public static void main(String[] args) {


    }


    public static void sumsum() {
        int i = 0;
        // 先赋值再相加
        i = i++;
//        i++;

        int j = 0;
        // 先相加再赋值
        j = ++j;
//        ++j;

        System.out.println(i);
        System.out.println(j);
    }


    /*
            int a = getValue(0);
        System.out.println(a);
     */
    public static int getValue(int i) {

        try {
            throw new Exception("try");
        } catch (Exception e) {
            System.out.println("catch");
            i++;
            return i;
        } finally {
            System.out.println("finally");
            ++i;
        }

    }
}
